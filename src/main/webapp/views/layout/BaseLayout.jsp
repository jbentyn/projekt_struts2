<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="views/layout/layout.css">
		<link rel="stylesheet" type="text/css" href="views/layout/bootstrap_cerulean.css">
		
		<script type="text/javascript" src="js/jquery/jquery-1.11.2.min.js"></script>
		
		<script type="text/javascript" src="js/jquery-ui-1.11.2.redmond/jquery-ui.min.js"></script>
		<link rel="stylesheet" type="text/css" href="js/jquery-ui-1.11.2.redmond/jquery-ui.structure.min.css">
		<link rel="stylesheet" type="text/css" href="js/jquery-ui-1.11.2.redmond/jquery-ui.theme.min.css">
		
		<title>Struts 2 NSAI</title>
	</head>
	<body>
		<div id="app-header" class="container">
			<tiles:insertAttribute name="header" />
		</div>

		<div id="app-body" class="container">
			<tiles:insertAttribute name="body" />
		</div>

		<div id="app-footer" class="container">
			<tiles:insertAttribute name="footer" />
		</div>
	</body>
</html>
