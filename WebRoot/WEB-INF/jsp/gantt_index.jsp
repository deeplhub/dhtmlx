<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
<link rel="stylesheet" href="static/css/dhtmlxgantt.css" type="text/css" media="screen" title="no title" charset="utf-8">
<script src="static/js/dhtmlxgantt.js"></script>
<script src="static/js/testdata.js"></script>
<style type="text/css">
		html, body{ height:100%; padding:0px; margin:0px; overflow: hidden;}
	</style>
</head>

	
<body>
	<div id="gantt_here" style='width: 1000px; height: 400px;'></div>
	<script type="text/javascript">
	//直接返回
	gantt.config.xml_date = "%Y-%m-%d %H:%i";
	gantt.init("gantt_here");
	gantt.load("ganttData?0_!nativeeditor_status=queried&ids=0");

	var dp = new gantt.dataProcessor("ganttData");
	dp.init(gantt);
</script>
</body>
</html>
