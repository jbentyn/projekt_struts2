<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="views/layout/layout.css">
		<title>Struts 2 NSAI</title>
	</head>
	<body>
		<div id="app-header">
			<tiles:insertAttribute name="header" />
		</div>

		<div id="app-body">
			<tiles:insertAttribute name="body" />
		</div>

		<div id="app-footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</body>
</html>
