package com.dhtmlx.dao;

import java.util.List;

import com.dhtmlx.model.GanttTask;

public interface GanttTaskDAO {

	/**
	 * 查询所有
	 * 
	 * */
	public List findAll();

	/**
	 * 查询单条
	 * 
	 * */
	public GanttTask find(Integer params);

	/**
	 * 添加
	 * 
	 * */
	public int save(GanttTask params);

	/**
	 * 更新
	 * 
	 * */
	public int update(GanttTask obj);

	/**
	 * 删除
	 * 
	 * */
	public int delete(GanttTask params);
}
