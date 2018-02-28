package com.dhtmlx.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dhtmlx.service.ChartService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class ChartTestService {

	@Resource
	private ChartService chartService;
	
	@Test
	public void findAll(){
		List list = chartService.findAll();
		System.out.println(list.size());
	}
}
