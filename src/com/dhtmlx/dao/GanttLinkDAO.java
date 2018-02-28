package com.dhtmlx.dao;

import java.util.List;

import com.dhtmlx.model.GanttLink;

public interface GanttLinkDAO {

	/**
	 * 查询所有
	 * 
	 * */
	public List findAll();

	/**
	 * 查询单条
	 * 
	 * */
	public GanttLink find(Integer params);

	/**
	 * 添加
	 * 
	 * */
	public int save(GanttLink params);

	/**
	 * 删除
	 * 
	 * */
	public int delete(GanttLink params);

	/**
	 * 更新
	 * 
	 * */
	public int update(GanttLink params);
}
