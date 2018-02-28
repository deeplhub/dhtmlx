package com.dhtmlx.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dhtmlx.dao.GanttTaskDAO;
import com.dhtmlx.model.GanttLink;
import com.dhtmlx.model.GanttTask;

@Service
public class GanttTaskService {

	@Resource
	private GanttTaskDAO ganttTaskDAO;
	
	/**
	 * 查询所有
	 * 
	 * */
	public List<GanttTask> findAll(){
		return ganttTaskDAO.findAll();
	}

	/**
	 * 条件查询
	 * 
	 * */
	public GanttTask find(Integer param) {
		GanttTask task = ganttTaskDAO.find(param);
		return task;
	}

	/**
	 * 编辑或更新
	 * 
	 * */
	public int edit(GanttTask params) {
		
		return ganttTaskDAO.update(params);
	}

	/**
	 * 添加
	 * 
	 * */
	public int create(GanttTask params) {
		
		return ganttTaskDAO.save(params);
	}

	/**
	 * 删除
	 * 
	 * */
	public int remove(GanttTask params) {
		
		return ganttTaskDAO.delete(params);
	}
}
