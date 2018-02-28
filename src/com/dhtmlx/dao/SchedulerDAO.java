package com.dhtmlx.dao;


import java.util.List;
import java.util.Map;

import com.dhtmlx.model.Scheduler;

public interface SchedulerDAO {
	
	/**
	 * 查询所有
	 * 
	 * */
	public List findAll();

	/**
	 * 查询单条
	 * 
	 * */
	public Scheduler find(Integer param);

	/**
	 * 添加
	 * 
	 * */
	public int save(Scheduler params);

	/**
	 * 更新
	 * 
	 * */
	public int update(Scheduler params);

	/**
	 * 删除
	 * 
	 * */
	public int delete(Integer param);

}
