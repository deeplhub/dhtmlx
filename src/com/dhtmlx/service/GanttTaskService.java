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
	 * ��ѯ����
	 * 
	 * */
	public List<GanttTask> findAll(){
		return ganttTaskDAO.findAll();
	}

	/**
	 * ������ѯ
	 * 
	 * */
	public GanttTask find(Integer param) {
		GanttTask task = ganttTaskDAO.find(param);
		return task;
	}

	/**
	 * �༭�����
	 * 
	 * */
	public int edit(GanttTask params) {
		
		return ganttTaskDAO.update(params);
	}

	/**
	 * ���
	 * 
	 * */
	public int create(GanttTask params) {
		
		return ganttTaskDAO.save(params);
	}

	/**
	 * ɾ��
	 * 
	 * */
	public int remove(GanttTask params) {
		
		return ganttTaskDAO.delete(params);
	}
}
