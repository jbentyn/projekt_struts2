<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="Tags.jsp" %>
           
<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
      <font color="red">
        Your login attempt was not successful due to <br/><br/>
        <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
      </font>
</c:if>