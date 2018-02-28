<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="static/css/dhtmlxscheduler.css"
	type="text/css" media="screen" title="no title" charset="utf-8">
<script src="static/js/dhtmlxscheduler.js"></script>
<script src="static/locale_cn.js"></script>
<script src="static/js/jquery-1.11.3.min.js"></script>
<style type="text/css" media="screen">
html, body {
	margin: 0px;
	padding: 0px;
	height: 100%;
	overflow: hidden;
}
</style>
<script type="text/javascript" charset="utf-8">
	function init() {
		scheduler.config.xml_date = "%Y-%m-%d %H:%i";
		scheduler.init('scheduler_here', new Date(), "week");
		scheduler.load("queryAllScheduler", "json");
	}

	//保存
	var convert = scheduler.date.date_to_str("%Y-%m-%d %H:%i");
	scheduler.attachEvent("onEventAdded", function(event_id, event_object) {
		var url = "addScheduler";
		var id = event_object.id;
		var text = event_object.text;
		// date 需要实现格式化
		var start_date = convert(event_object.start_date);
		var end_date = convert(event_object.end_date);
		var details = event_object.details;
		var str = start_date + "#" + end_date + "#" + text;
		$.ajax({
			type : "POST",
			url : url,
			data : {
				"text" : text,
				"start_date" : start_date,
				"end_date" : end_date
			},
			success : function(data) {
				if(data == 0){
					location.reload();
					//location=location;
				}else{
					alert("添加失败");
				}
			}
		});
	});

	//删除
	scheduler.attachEvent("onBeforeEventDelete", function(event_id, event_object) {
		var url = "removeScheduler";
		var id = event_object.id;
		var text = event_object.text;
		$.ajax({
			type : "POST",
			url : url,
			dataType:"text",
			data:{"param":id},
			success : function(data) {
				if(data == 0){
					location.reload();
					//location=location;
				}else{
					alert("删除失败");
				}
			}
		});
	});
	
	//修改事件
	scheduler.attachEvent("onEventChanged", function(event_id, event_object) {
		var url = "editScheduler";
		var id = event_object.id;
		var text = event_object.text;
		var start_date = convert(event_object.start_date);
		var end_date = convert(event_object.end_date);
		var details = event_object.details;
		var scheduler_type = event_object.scheduler_type;
		var warn_date = event_object.warn_date;
		var pars = "id=" + id + "&start_date=" + start_date + "&end_date="
				+ end_date + "&text=" + text + "&details=" + details;

		var str = start_date + "#" + end_date + "#" + text + "#" + id;
		$.ajax({
			url : url,
			type : "POST",
			data : {
				"id" : id,
				"text" : text,
				"start_date" : start_date,
				"end_date" : end_date,
				"scheduler_type" : scheduler_type,
				// 这个只是一个临时变量
				"warn_info" : warn_date
			},
			success : function(data) {
				if(data == 0){
					location.reload();
				}else{
					alert("更新失败");
				}
			}
		});
	});
</script>
</head>

<body onload="init();">
	<div id="scheduler_here" class="dhx_cal_container"
		style='width: 100%; height: 100%;'>
		<div class="dhx_cal_navline">
			<div class="dhx_cal_prev_button">&nbsp;</div>
			<div class="dhx_cal_next_button">&nbsp;</div>
			<div class="dhx_cal_today_button"></div>
			<div class="dhx_cal_date"></div>
			<div class="dhx_cal_tab" name="day_tab" style="right: 204px;"></div>
			<div class="dhx_cal_tab" name="week_tab" style="right: 140px;"></div>
			<div class="dhx_cal_tab" name="month_tab" style="right: 76px;"></div>
		</div>
		<div class="dhx_cal_header"></div>
		<div class="dhx_cal_data"></div>
	</div>
</body>

</html>
