package com.dhtmlx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dhtmlx.model.Scheduler;
import com.dhtmlx.service.SchedulerService;


/**
 * @author hyang
 * @date 2016年8月24日下午9:06:07
 * @explain 日程
 * 
 */
@Controller
@SuppressWarnings("all")
public class SchedulerController {

	@Resource
	private SchedulerService schedulerService;

	@RequestMapping(value = "goScheduler")
	public String goScheduler() {

		return "scheduler_index";
	}
	
	/**
	 * 查询列表
	 * 
	 * */
	@RequestMapping(value = "queryAllScheduler", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Map queryAllScheduler(){
		List list = schedulerService.findAll();
		System.out.println("============="+list.size());
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("data", list);
		return map;
	}

	/**
	 * 添加
	 * 
	 * */
	@RequestMapping(value = "addScheduler", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String addScheduler(Scheduler params) {
		System.out.println("=================="+params.toString());
		
		int result = schedulerService.add(params);
		String msg = result > 0 ? "添加成功" : "添加失败";
		System.out.println(msg);
		return result > 0 ? "0" : "1";
	}
	
	/**
	 * 更新
	 * 
	 * */
	@RequestMapping(value = "editScheduler", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String editScheduler(Scheduler params) {
		System.out.println("=================="+params.toString());
		
		Scheduler scheduler = schedulerService.find(params.getId());
		scheduler.setText(params.getText());
		scheduler.setStart_date(params.getStart_date());
		scheduler.setEnd_date(params.getEnd_date());
		scheduler.setScheduler_type(params.getScheduler_type());
		scheduler.setWarn_date(params.getWarn_date());
		scheduler.setWarn_info(params.getWarn_info());
		
		int result = schedulerService.edit(scheduler);
		String msg = result > 0 ? "更新成功" : "更新失败";
		System.out.println(msg);
		return result > 0 ? "0" : "1";
	}
	
	/**
	 * 删除
	 * 
	 * */
	@RequestMapping(value = "removeScheduler", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String removeScheduler(Integer param) {
		System.out.println("=================="+param);
		
		int result = schedulerService.remove(param);
		String msg = result > 0 ? "删除成功" : "删除失败";
		System.out.println(msg);
		return result > 0 ? "0" : "1";
	}

}
