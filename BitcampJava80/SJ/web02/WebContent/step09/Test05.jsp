<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" buffer="8kb" autoFlush="true"
	trimDirectiveWhitespaces="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<jsp:include page="../step07/BasicStyle.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>JSTL 사용법 : Core 라이브러리</h1>
	<h2>c:choose</h2>
	<pre>
  => 조건문 생성 태그
  # 문법 
  &lt;c:choose>
    &lt;c:when test="조건식">콘텐츠&lt;/c:when>
    &lt;c:when test="조건식">콘텐츠&lt;/c:when>
    &lt;c:when test="조건식">콘텐츠&lt;/c:when>
    &lt;c:when test="조건식">콘텐츠&lt;/c:when>
    ...
    &lt;c:otherwise>콘텐츠&lt;/c:otherwise>
  &lt;/c:choose>
  => 조건식은 EL 을 사용한다.
  # 사용 예
  <c:set var="age" value="22"/>
  <c:choose>
    <c:when test="${age >= 0 && age < 19}">미성년입니다</c:when>
    <c:when test="${age >= 19 && age < 65 }">미성년입니다</c:when>
    <c:when test="${age >= 65}">미성년입니다</c:when>
    <c:otherwise>잘못된 값입니다.</c:otherwise>
  </c:choose>
	</pre>
</body>
</html>

