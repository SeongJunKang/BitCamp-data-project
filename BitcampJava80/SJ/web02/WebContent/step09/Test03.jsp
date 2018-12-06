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
	<h2>c:set</h2>
	<pre>
  => 보관소에 저장되는 변수를 생성하는 태그.
  # 문법 
  &lt; c:set var="변수명" value="값" scope="page(default)|request|session|application"/>
  &lt; c:set var="변수명" scope="page|request|session|application">값&lt;/c:set>
  
  # 자바코드
  pageContext.setAttribute("변수명",값);
  request.setAttribute("변수명",값);
  session.setAttribute("변수명",값);
  application.setAttribute("변수명",값);

  # 사용 예
  <c:set var="v1" value="변수1" scope="page" />
  <c:set var="v2" value="변수2" />
  <c:set var="v3">변수3</c:set>
  page	 
  => v1 = ${pageScope.v1}
  => v2 = ${pageScope.v2}
  => v3 = ${pageScope.v3}
  request
  => v1 = ${requestScope.v1}
  => v2 = ${requestScope.v2}
  => v3 = ${requestScope.v3}
	</pre>
	<h2>c:remove</h2>
	<pre>
  => 보관소에 저장되는 변수를 제거하는 태그.
  # 문법 
  &lt; c:remove var="변수명" scope="page(default)|request|session|application"/>
  
  # 자바코드로 표현하면 다음과 같다.
  pageContext.removeAttribute("변수명");
  request.removeAttribute("변수명");
  session.removeAttribute("변수명");
  application.removeAttribute("변수명");
  
  #사용 예
  <c:remove var="v1" />
  => v1 = ${pageScope.v1}
  => v2 = ${pageScope.v2}
  => v3 = ${pageScope.v3}
  </pre>
</body>
</html>

