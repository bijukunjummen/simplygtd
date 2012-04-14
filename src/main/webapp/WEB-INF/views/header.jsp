<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<spring:url var="home" value="/" />
<spring:message code="button_home" var="home_label" />
<h3 class="alt">
	<a href="${home}" title="${fn:escapeXml(home_label)}"> Home </a>
</h3>
