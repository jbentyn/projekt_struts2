<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="Tags.jsp" %>


<s:form id="other-form" method="POST" theme="simple">
	<span><s:text name="labels.other.otherView"/></span>
	<div id="string-lists" style="width: 500px; background: #afeeee; padding: 50px;">
		<jsp:include page="ajax/StringsList.jsp" />
	</div>
</s:form>
