package com.dhtmlx.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dhtmlx.model.GanttTask;
import com.dhtmlx.service.GanttTaskService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class GanttTaskTestService {

	@Resource
	private GanttTaskService ganttTaskService;
	
	@Test
	public void insert(){
		GanttTask task = new GanttTask();
		task.setText("GGG");
		task.setStart_date("1900-01-01 00:00");
		task.setDuration(1);
		task.setProgress(1);
		task.setSortorder(1);
		task.setParent(0);
		int number = ganttTaskService.create(task);
		System.out.println(number);
	}
}
