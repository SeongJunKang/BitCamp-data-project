<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" buffer="8kb" autoFlush="true"
	trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<jsp:include page="../step07/BasicStyle.jsp" />
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>JSTL 사용법 : Core 라이브러리</h1>
	<h2>c:out</h2>
	<pre>
	=> 출력문을 만드는 태그이다.
	# 문법 
	&lt; c:out value="출력할 값" default="기본 값"/>
	&lt; c:out value="출력할 값">기본 값 &lt;/c:out>
	
	# 사용 예
	=> <c:out value="끄래" default="기본 값" />
	=> <c:out value="${null}" default="기본 값" />
	=> <c:out value="${null}">기본 값</c:out>
	=> <c:out value="${null}" />
	</pre>
</body>
</html>

