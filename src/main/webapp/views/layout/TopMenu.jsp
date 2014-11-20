<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div style="background: #ff7373">
	<span style="color: black"><s:text name="labels.menu.example"/></span>
	<s:form method="POST">
		<s:submit action="testOtherAction" value="test other action"/>
	</s:form>
</div>
