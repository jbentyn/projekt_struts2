<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../Tags.jsp"%>

<!-- URLS -->
<s:url id="appointment" namespace="/" action="initAppointment" />

<s:url id="user" namespace="/" action="listUser" />
<s:url id="register" namespace="/" action="initRegisterUser" />
<s:url id="login" namespace="/" action="initLogin" />
<s:url id="logout" namespace="/" action="initLogin"  >
</s:url>

<s:url id="doctor" namespace="/" action="initDoctor" />
<s:url id="contacts" namespace="/" action="contacts" />
<s:url id="home" namespace="/" action="Welcome" />

<div id="header-top">
	<span id="logo"> <s:a href="%{home}">
			<img alt="logo" src="images/logo.png" />
		</s:a> <span>Dental Care for you</span>

	</span>
	<div class="float-right">
		<sec:authorize access="isAuthenticated() ">
		Logged in as: <sec:authentication property="principal" /> <a href="logout">Logout</a></span>
		</sec:authorize>
		<sec:authorize access="isAnonymous()">
			<span> <s:a href="%{register}">Register</s:a></span>
			<span> <s:a href="%{login}">Login</s:a></span>
		</sec:authorize>

	</div>

</div>

<!-- nav menu -->

<div class="navbar navbar-default">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
			<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<s:a cssClass="navbar-brand" href="%{home}">Home</s:a>
	</div>

	<div class="navbar-collapse collapse navbar-responsive-collapse">
		<ul class="nav navbar-nav">
			<li><s:a href="%{appointment}">Make appointment</s:a></li>
			<li><s:a href="%{contacts}">Contact Us</s:a></li>
		</ul>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a  class="dropdown-toggle" data-toggle="dropdown">Administration<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><s:a href="%{user}">Users</s:a></li>
						<li><s:a href="%{doctor}">Doctors</s:a></li>
						<li><s:a href="%{appointment}">Appointments</s:a></li>
					</ul></li>
			</ul>
		</sec:authorize>
	</div>
</div>
