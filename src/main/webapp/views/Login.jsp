<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- INCLUDE IT TO HAVE ACCESS TO THE STRUTS 2 TAGS --%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div>
	<s:actionerror/>

	<s:form method="POST" action="loginLogin">
		<s:textfield name="username" key="labels.login.username"/>
		<s:password name="password" key="labels.login.password"/>
		
		<s:submit  key="buttons.login"/>
		<s:submit  key="buttons.register" action="inputRegister"/>
	</s:form>
	
<s:form method="POST" action="jpaTestLogin">
<s:textfield name="username" key="labels.login.username"/>
		<s:submit  key="labels.login.password" />
</s:form>
	
</div>