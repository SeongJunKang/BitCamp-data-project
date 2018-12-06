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
	<h2>c:if</h2>
	<pre>
  => 조건문 생성 태그
  # 문법 
  &lt;c:if test="조건식" var="변수명" scope="page(default)|request|session|application">
  콘텐츠
  &lt;/c:if>
  => 조건식은 EL 을 사용한다.
  => 변수명을 지정하면, 조건의 결과가 보관소에 지정된 변수명으로 저장된다.
  # 사용 예
  <c:if test="${10 < 20}" var="test1">
  10은 20보다 작다.
  </c:if>
  <c:if test="${10 > 20}" var="test2">
  10은 20보다 크다.
  </c:if>
	</pre>

</body>
</html>

