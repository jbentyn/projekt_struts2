<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		
		<script type="text/javascript" src="js/jquery/jquery-1.11.2.min.js"></script>
		
		<script type="text/javascript" src="js/jquery-ui-1.11.2.redmond/jquery-ui.min.js"></script>
		<link rel="stylesheet" type="text/css" href="js/jquery-ui-1.11.2.redmond/jquery-ui.structure.min.css">
		<link rel="stylesheet" type="text/css" href="js/jquery-ui-1.11.2.redmond/jquery-ui.theme.min.css">
		
		<link rel="stylesheet" type="text/css" href="views/layout/layout.css">
		<link rel="stylesheet" type="text/css" href="views/layout/bootstrap_cerulean.css">
		 <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
		 
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
