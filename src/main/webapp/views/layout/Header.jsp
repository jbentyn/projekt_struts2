<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div>
	<span style="text-align: center;margin-left: 45%;"><s:text name="labels.header.example"/></span>
</div>

<s:url id="loginEN" namespace="/" action="locale" >
      <s:param name="request_locale" >en</s:param>
   </s:url>
   <s:url id="loginPL" namespace="/" action="locale" >
      <s:param name="request_locale" >pl</s:param>
   </s:url>

<div class="languages">
	<span> <s:a href="%{loginEN}" >English</s:a></span>
	<span> <s:a href="%{loginPL}" >Polski</s:a></span>
</div>

