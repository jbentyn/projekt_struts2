
<%@ include file="Tags.jsp"%>

<s:if test="hasActionErrors()">
	<div class="alert alert-dismissable alert-danger">
		<s:actionerror />
	</div>
</s:if>

<s:if test="hasActionMessages()">
	<div class="alert alert-dismissable alert-success">
		<s:actionmessage />
	</div>
</s:if>

