package com.dhtmlx.dao;


import java.util.List;
import java.util.Map;

import com.dhtmlx.model.Scheduler;

public interface SchedulerDAO {
	
	/**
	 * ��ѯ����
	 * 
	 * */
	public List findAll();

	/**
	 * ��ѯ����
	 * 
	 * */
	public Scheduler find(Integer param);

	/**
	 * ���
	 * 
	 * */
	public int save(Scheduler params);

	/**
	 * ����
	 * 
	 * */
	public int update(Scheduler params);

	/**
	 * ɾ��
	 * 
	 * */
	public int delete(Integer param);

}
