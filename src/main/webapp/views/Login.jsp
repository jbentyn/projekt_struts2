<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- INCLUDE IT TO HAVE ACCESS TO THE STRUTS 2 TAGS --%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div>
	<s:actionerror />
SPRING SECURITY
<s:form action="j_spring_security_check" method="post">
    <s:textfield name="j_username"  key="labels.login.username"  />
    <s:password name="j_password" key="labels.login.password"  />
     <input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <s:submit name="submit" key="buttons.login" />
</s:form>
</div>