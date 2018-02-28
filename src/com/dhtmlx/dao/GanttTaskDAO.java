package com.dhtmlx.dao;

import java.util.List;

import com.dhtmlx.model.GanttTask;

public interface GanttTaskDAO {

	/**
	 * ��ѯ����
	 * 
	 * */
	public List findAll();

	/**
	 * ��ѯ����
	 * 
	 * */
	public GanttTask find(Integer params);

	/**
	 * ���
	 * 
	 * */
	public int save(GanttTask params);

	/**
	 * ����
	 * 
	 * */
	public int update(GanttTask obj);

	/**
	 * ɾ��
	 * 
	 * */
	public int delete(GanttTask params);
}
