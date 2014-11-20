<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- INCLUDE ITS TO HAVE ACCESS TO THE STRUTS 2 TAGS --%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div>
	<s:text name="labels.welcome.welcomeText"/>&nbsp;<s:property value="username"/>
</div>