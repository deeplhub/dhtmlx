package com.dhtmlx.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dhtmlx.dao.ChartDAO;

@Service
public class ChartService {

	@Resource
	private ChartDAO chartDAO;
	
	public List findAll(){
		
		return chartDAO.findAll();
	}
	
}
