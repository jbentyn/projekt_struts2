<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="Tags.jsp" %>
<div>
	<s:actionerror />
	SPRING SECURITY
	  <s:if test="%{#parameters.error != null}">
            <div style="color: red">Invalid User</div>
        </s:if>
        
	<%-- <s:form action="/j_spring_security_check" method="post">
		<s:textfield name="j_username" key="labels.login.username" />
		<s:password name="j_password" key="labels.login.password" />
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<s:submit name="submit" key="buttons.login" />
	</s:form> --%>
	
	<form name='loginForm'
		    action="<c:url value='j_spring_security_check' />" method='POST'>
 
		    <table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='user' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='pass' /></td>
			</tr>
			<tr>
			        <td colspan='2'>
                                <input name="submit" type="submit" value="submit" />
                                </td>
			</tr>
		   </table>
 
		   <input type="hidden" 
                     name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	<sec:authorize access="hasRole('user')">Authenticated</sec:authorize>
</div>