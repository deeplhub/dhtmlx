package com.dhtmlx.test;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dhtmlx.model.Scheduler;
import com.dhtmlx.service.SchedulerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class SchedulerTestService {
	
	@Resource
	private SchedulerService schedulerService;
	
	//@Test
	public void findAll(){
		List list = schedulerService.findAll();
		//for (int i = 0; i < list.size(); i++) {
			System.out.println(list.toString());
		//}
	}
	
	@Test
	public void edit(){
		Scheduler scheduler = schedulerService.find(13);
		scheduler.setText("B1新建日程B1");
//		scheduler.setStart_date("2016-08-25 03:55");
//		scheduler.setEnd_date("2016-08-25 04:55");
		
		int result = schedulerService.edit(scheduler);
		System.out.println(result);
		
	}

}
