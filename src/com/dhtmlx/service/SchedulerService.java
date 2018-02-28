package com.dhtmlx.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dhtmlx.dao.SchedulerDAO;
import com.dhtmlx.model.Scheduler;
import com.dhtmlx.util.DateUtils;

@Service
public class SchedulerService {

	@Resource
	private SchedulerDAO schedulerDAO;
	
	/**
	 * ��ѯ����
	 * 
	 * */
	public List findAll(){
		
		return schedulerDAO.findAll();
	}

	/**
	 * ������ѯ
	 * 
	 * */
	public Scheduler find(Integer param) {
		Scheduler scheduler = schedulerDAO.find(param);
		
		return scheduler;
	}

	/**
	 * �༭
	 * 
	 * */
	public int edit(Scheduler params) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date;
		try {
			date = DateUtils.time2millisecond(sdf.parse(params.getEnd_date()), params.getWarn_info(), "yyyy-MM-dd HH:mm:ss");
			params.setWarn_date(sdf.format(date));
			return schedulerDAO.update(params);
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * ���
	 * 
	 * */
	public int add(Scheduler params) {
		
		return schedulerDAO.save(params);
	}

	/**
	 * ɾ��
	 * 
	 * */
	public int remove(Integer param) {
		
		return schedulerDAO.delete(param);
	}
	
}
