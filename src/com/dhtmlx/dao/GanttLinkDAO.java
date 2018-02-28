package com.dhtmlx.dao;

import java.util.List;

import com.dhtmlx.model.GanttLink;

public interface GanttLinkDAO {

	/**
	 * ��ѯ����
	 * 
	 * */
	public List findAll();

	/**
	 * ��ѯ����
	 * 
	 * */
	public GanttLink find(Integer params);

	/**
	 * ���
	 * 
	 * */
	public int save(GanttLink params);

	/**
	 * ɾ��
	 * 
	 * */
	public int delete(GanttLink params);

	/**
	 * ����
	 * 
	 * */
	public int update(GanttLink params);
}
