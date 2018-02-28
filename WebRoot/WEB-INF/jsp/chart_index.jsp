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
<link rel="stylesheet" href="static/chart/dhtmlxchart.css" type="text/css" media="screen" title="no title" charset="utf-8">
<link rel="stylesheet" href="static/chart/roboto.css" type="text/css" media="screen" title="no title" charset="utf-8">
<script src="static/chart/dhtmlxchart.js"></script>
<style>
.dhx_chart_title {
	padding-left: 3px
}
</style>
<script type="text/javascript" charset="utf-8">
var myBarChart;
function doOnLoad() {
	myBarChart = new dhtmlXChart({
		view : "bar",
		container : "chartDiv",
		value : "#sales#",
		radius : 0,
		border : true,
		color:"#b9a8f9",
		xAxis : {
			template : "'#year#"
		},
		yAxis : {
			start : 0,
			end : 100,
			step : 10,
			template : function(obj) {
				return (obj % 10 ? "" : obj)
			}
		}
	});
	
	myBarChart.addSeries({
		 view: "line",
	     item:{  radius:0 },
	     line:{  color:"#36abee" },
	     value:"#sales#"
	});
	
	myBarChart.addSeries({
	    value:"#sales#",
	    color:"#a7ee70"
	});
	//myBarChart.parse(data, "json");
	myBarChart.load("queryAllChart","json");
}
</script>
</head>

<body onload="doOnLoad();">
	<div id="chartDiv" style="width: 600px; height: 250px; margin: 20px; border: 1px solid #c0c0c0"></div>
</body>

</html>
