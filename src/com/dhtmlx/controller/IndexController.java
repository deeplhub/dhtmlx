package com.dhtmlx.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dhtmlx.model.ActionResult;
import com.dhtmlx.model.GanttLink;
import com.dhtmlx.model.GanttTask;
import com.dhtmlx.service.GanttLinkService;
import com.dhtmlx.service.GanttTaskService;
import com.sdicons.json.mapper.JSONMapper;
import com.sdicons.json.mapper.MapperException;
import com.sdicons.json.mapper.helper.impl.DateMapper;
import com.sdicons.json.model.JSONValue;

/**
 * @author hyang
 * @date 2016年8月24日下午9:06:07
 * @explain 甘特图
 * 
 */
@Controller
public class IndexController {

	@Resource
	private GanttLinkService ganttLinkService;
	@Resource
	private GanttTaskService ganttTaskService;

	// 操作状态
	private final static String ERROR = "error";
	private final static String INVALID = "invalid";
	private final static String INSERTED = "inserted";
	private final static String UPDATED = "updated";
	private final static String DELETED = "deleted";
	private final static String QUERIED = "queried";
	// 时间格式化格式
	public final static String TIMEPATTERN = "yyyy-MM-dd HH:mm:ss";

	
	@RequestMapping(value = "goGantt")
	public String goGantt(){
		
		System.out.println("===================goGantt===================");
		return "gantt_index";
	}
	
	
	@RequestMapping(value = "ganttData")
	public void ganttData(HttpServletRequest request, HttpServletResponse response) {
		String[] ids = this.getIds(request);
		List<Map> params = this.getPostValues(ids, request);
		List<ActionResult> results = new ArrayList<>();
		boolean roolback = false;
		for (Map<String, String> param : params) {
			// 获取对象实体类型
			Class<?> clazz = this.mode2EntityType(param.get("mode"));
			// 判断对象操作类型 inserted updated deleted
			String outerOp = param.get("!nativeeditor_status");
			// 返回的提示信息
			String output = null;
			String id = param.get("id");
			String nid = id;
			// 仅对数据抛出的异常操作.
			try {
				// 操作对象
				switch (outerOp) {
				case QUERIED:
					List<GanttLink> links = ganttLinkService.findAll();
					List<GanttTask> tasks = ganttTaskService.findAll();
					String ret = this.toJson(links, tasks);
					response.setCharacterEncoding("UTF-8");
					try (PrintWriter out = response.getWriter()) {
						out.print(ret);
						out.flush();
					}
					return;
				// 更新实体
				case UPDATED:
					if (clazz.equals(GanttLink.class)) {
						GanttLink link = ganttLinkService.find(Integer.valueOf(id));
						link.setSource(Integer.valueOf(param.get("source")));
						link.setTarget(Integer.valueOf(param.get("target")));
						link.setType(param.get("type"));
						int result = ganttLinkService.edit(link);
						String msg = result > 0 ? "更新成功" : "更新失败";
						System.out.println(msg);
						nid = String.valueOf(link.getId());
					} else if (clazz.equals(GanttTask.class)) {
						GanttTask task = ganttTaskService.find(Integer.valueOf(id));
						task.setDuration(Integer.valueOf(param.get("duration")));
						task.setParent(Integer.valueOf(param.get("parent")));
						task.setProgress(Float.valueOf(param.get("progress")));
						if (null != param.get("sortorder")) {
							task.setSortorder(Integer.valueOf(param.get("sortorder")));
						}
						//obj.setStart_date(DateUtils.parse(param.get("start_date"), TIMEPATTERN));
						task.setStart_date(param.get("start_date"));
						task.setText(param.get("text"));
						int result = ganttTaskService.edit(task);
						String msg = result > 0 ? "更新成功" : "更新失败";
						System.out.println(msg);
						nid = String.valueOf(task.getId());
					}
					break;
				case INSERTED:
					if (clazz.equals(GanttLink.class)) {
						GanttLink obj = (GanttLink) this.getNewEntityInstance(clazz, param);
						int result = ganttLinkService.create(obj);
						String msg = result > 0 ? "更新成功" : "更新失败";
						System.out.println(msg);
						nid = String.valueOf(obj.getId());
					} else if (clazz.equals(GanttTask.class)) {
						GanttTask obj = (GanttTask) this.getNewEntityInstance(clazz, param);
						int result = ganttTaskService.create(obj);
						String msg = result > 0 ? "更新成功" : "更新失败";
						System.out.println(msg);
						nid = String.valueOf(obj.getId());
					}
					break;
				case DELETED:
					if (clazz.equals(GanttLink.class)) {
						GanttLink obj = ganttLinkService.find(Integer.valueOf(id));
						int result = ganttLinkService.remove(obj);
						String msg = result > 0 ? "更新成功" : "更新失败";
						System.out.println(msg);
					} else if (clazz.equals(GanttTask.class)) {
						GanttTask obj = ganttTaskService.find(Integer.valueOf(id));
						int result = ganttTaskService.remove(obj);
						String msg = result > 0 ? "更新成功" : "更新失败";
						System.out.println(msg);
					}
					break;
				default:
					outerOp = INVALID;
					break;
				}
			} catch (Exception e) {
				System.out.println(e);
				roolback = true;
				break;
			} finally {
				results.add(new ActionResult(outerOp, id, nid, output, null));
			}
		} // end for
			// 处理是否回滚事件
		if (roolback) {
			for (ActionResult ar : results) {
				ar.setStatus(ERROR);
			}
		}
		this.outputAsXml(results, response);
	}

	/**
	 * 把字符串分隔成String数组
	 * 
	 * */
	private String[] getIds(HttpServletRequest request) {
		String value = request.getParameter("ids");
		return value.split(",");
	}

	/**
	 * 检索数据和规范化
	 * 
	 * 注意此方法有待验证正确性
	 * 
	 * */
	private List<Map> getPostValues(String[] ids, HttpServletRequest request) {
		List<Map> rets = new ArrayList<>();
		for (String id : ids) {
			Map<String, String> ret = new HashMap<>();
			Enumeration params = request.getParameterNames();
			while (params.hasMoreElements()) {
				String name = String.valueOf(params.nextElement());
				// 判断是不是合法的参数
				if (!name.startsWith(id + "_") || name.split("_").length < 2) {
					if (!name.equals("gantt_mode")) {
						continue;
					}
				}
				ret.put(name.substring(name.indexOf("_") + 1), request.getParameter(name));
			}
			rets.add(ret);
		} // end for
		return rets;
	}

	/**
	 * 传入的数据名称转换为有效实体类类型
	 * 
	 * */
	private Class mode2EntityType(String name) {
		if (name != null) {
			switch (name) {
			case "tasks":
				return GanttTask.class;
			case "links":
				return GanttLink.class;
			default:
				throw new RuntimeException("不匹配的请求.");
			}
		}
		return null;
	}

	/**
	 * 把实体类数据转换JSON
	 * 
	 * */
	private String toJson(List<GanttLink> ganttLinks, List<GanttTask> ganttTasks) {
		String json = null;
		try {
			Map<String, Object> root = new HashMap();
			root.put("data", ganttTasks);
			Map<String, List> links = new HashMap<>();
			links.put("links", ganttLinks);
			root.put("collections", links);
			JSONMapper.addHelper(new DateMapper());
			JSONValue value = JSONMapper.toJSON(root);
			json = value.render(true);
		} catch (MapperException ex) {
			Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, "json解析错误.", ex);
		}
		System.out.println(json);
		return json;
	}

	/**
	 * 把map转换实体
	 * 
	 * */
	private Object getNewEntityInstance(Class clazz, Map<String, String> param) {
		if (clazz.equals(GanttLink.class)) {
			GanttLink gl = new GanttLink();
			gl.setSource(Integer.valueOf(param.get("source")));
			gl.setTarget(Integer.valueOf(param.get("target")));
			gl.setType(param.get("type"));
			return gl;
		} else if (clazz.equals(GanttTask.class)) {
			GanttTask gt = new GanttTask();
			
			gt.setText(param.get("text"));
			//gt.setStart_date(DateUtils.parse(param.get("start_date"), TIMEPATTERN));
			gt.setStart_date(param.get("start_date"));
			gt.setDuration(Integer.valueOf(param.get("duration")));
			
			if(param.get("parent") != null){
				gt.setParent(Integer.valueOf(param.get("parent")));
			}
			if(param.get("progress") != null){
				gt.setProgress(Float.valueOf(param.get("progress")));
			}
			if (null != param.get("sortorder")) {
				gt.setSortorder(Integer.valueOf(param.get("sortorder")));
			}
			return gt;
		}
		return null;
	}

	/**
	 * 把数据转换xml转换成流输出到页面
	 * 
	 * 
	 * */
	private void outputAsXml(List<ActionResult> results, HttpServletResponse response) {
		try (PrintWriter out = response.getWriter()) {
			response.setContentType("text/xml");
			StringBuilder sBuilder = new StringBuilder("<?xml version='1.0' ?>");
			sBuilder.append("<data>");
			for (ActionResult result : results) {
				sBuilder.append(result.resultToXml());
			}
			sBuilder.append("</data>");
			out.print(sBuilder);
			out.flush();
		} catch (IOException ex) {
			//Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, "IO异常.", ex);
			System.out.println("outputAsXml出现的异常");
		}
	}
}
