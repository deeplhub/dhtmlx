package com.dhtmlx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dhtmlx.service.ChartService;
/**
 * @author hyang
 * @date 2016年8月24日下午9:06:07
 * @explain 图表
 * 
 */
@Controller
public class ChartController {
	
	@Resource
	private ChartService chartService;
	
	@RequestMapping(value = "goChart")
	public String goChart(){
		
		return "chart_index";
	}
	
	@RequestMapping(value = "queryAllChart", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Map queryAllChart(){
		List list = chartService.findAll();
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("data", list);
		return map;
	}

}
