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
	<h2>c:import</h2>
	<pre>
  => HTTP 요청을 수행하는 태그.  
  # 문법
  &lt;c:import url="URL 지정" var="변수명" scope="page(default)|request|session|application"/>
  => 변수명을 지정하면 보관소에 그 변수 이름으로 결과를 저장한다.
  => 변수명을 지정하지 않으면 응답 결과를 그 자리에 놓는다.
  
  # 사용 예
	<c:import url="http://www.naver.com/" var="pageResult"/>
	</pre>
  <textarea rows="20" cols="200" value='${pageResult}'></textarea>
  <hr>
  <textarea rows="20" cols="200"><c:import url="http://www.daum.net/"/></textarea>
  
</body>
</html>

