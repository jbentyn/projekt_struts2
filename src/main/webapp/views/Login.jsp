<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="Tags.jsp"%>

<div class="form-container">

	<s:if test="%{#parameters.error != null}">
		<div class="alert alert-dismissable alert-danger">Invalid username or password</div>
	</s:if>


	<!--   IMPORTANT: action name same as provided in fromLogin in Spring Security configuration -->
	<s:form action="initLogin" method="post" cssClass="form-horizontal">
		<legend>Login</legend>
		<div class="form-group">
			<label for="username" class="col-lg-2 control-label">Username</label>
			<div class="col-lg-10">
				<input name="username" class="form-control" id="username" placeholder="Login" type="text">
			</div>
		</div>
		<div class="form-group">
			<label for="password" class="col-lg-2 control-label">Password</label>
			<div class="col-lg-10">
				<input name="password" class="form-control" id="password" placeholder="Password" type="password">
			</div>
		</div>


		<div class="form-group">
			<div class="col-lg-10 col-lg-offset-2">
				<button type="submit" class="btn btn-primary float-right">Login</button>
			</div>
		</div>
	</s:form>
</div>