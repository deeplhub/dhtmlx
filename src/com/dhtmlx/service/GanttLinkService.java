package com.dhtmlx.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dhtmlx.dao.GanttLinkDAO;
import com.dhtmlx.model.GanttLink;

@Service
public class GanttLinkService {

	@Resource
	private GanttLinkDAO ganttLinkDAO;
	
	/**
	 * 查询所有
	 * 
	 * */
	public List<GanttLink> findAll(){
		
		return ganttLinkDAO.findAll();
	}

	/**
	 * 条件查询
	 * 
	 * */
	public GanttLink find(Integer param) {
		GanttLink links = ganttLinkDAO.find(param);
		return links;
	}

	/**
	 * 编辑
	 * 
	 * */
	public int edit(GanttLink params) {
		
		return ganttLinkDAO.update(params);
	}

	/**
	 * 添加
	 * 
	 * */
	public int create(GanttLink params) {
		
		return ganttLinkDAO.save(params);
	}

	/**
	 * 删除
	 * 
	 * */
	public int remove(GanttLink params) {
		
		return ganttLinkDAO.delete(params);
	}
}
