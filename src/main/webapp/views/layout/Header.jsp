<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!-- URLS -->
<s:url id="loginEN" namespace="/" action="locale">
	<s:param name="request_locale">en</s:param>
</s:url>
<s:url id="loginPL" namespace="/" action="locale">
	<s:param name="request_locale">pl</s:param>
</s:url>
<s:url id="appointment" namespace="/" action="initAppointment"/>


<div id="header-top">
<span id="logo">
<img alt="logo" src="images/logo.png"/>
<span>Dental Care for you</span>
</span>
	<div class="languages">
		<span> <s:a href="%{loginEN}">English</s:a></span> <span> <s:a href="%{loginPL}">Polski</s:a></span>
	</div>

</div>

<!-- nav menu -->

<div class="navbar navbar-default">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
			<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="#">Home</a>
	</div>
	<div class="navbar-collapse collapse navbar-responsive-collapse">
		<ul class="nav navbar-nav">
			<li><s:a href="%{appointment}">Make appointment</s:a></li>
			<li><a href="#">Contact Us</a></li>
			
		</ul>
		
	</div>
</div>

