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
	 * ��ѯ����
	 * 
	 * */
	public List<GanttLink> findAll(){
		
		return ganttLinkDAO.findAll();
	}

	/**
	 * ������ѯ
	 * 
	 * */
	public GanttLink find(Integer param) {
		GanttLink links = ganttLinkDAO.find(param);
		return links;
	}

	/**
	 * �༭
	 * 
	 * */
	public int edit(GanttLink params) {
		
		return ganttLinkDAO.update(params);
	}

	/**
	 * ���
	 * 
	 * */
	public int create(GanttLink params) {
		
		return ganttLinkDAO.save(params);
	}

	/**
	 * ɾ��
	 * 
	 * */
	public int remove(GanttLink params) {
		
		return ganttLinkDAO.delete(params);
	}
}
