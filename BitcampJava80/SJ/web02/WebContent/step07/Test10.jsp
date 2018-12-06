<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" buffer="8kb" autoFlush="true"
	trimDirectiveWhitespaces="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP</title>
<style>
pre {
	font-family: monospace;
	background-color: lightgray;
}

p {
	background-color: orange;
}
</style>
</head>
<body>
	<h1>JSP 액션 태그 - jsp:useBean 사용법3</h1>
	<h2>use:Bean vs Java code</h2>
	<p>&lt;jsp:useBean id="map1" type="java.util.Map"
		class="java.lang.HashMap" scope="request"/></p>
	<pre>
  //레퍼런스 변수의 타입은 type 속성을 사용한다.
  java.util.Map map1 = (java.util.Map)request.getAttribute("map1");
  if (map1 == null) {
    // 객체를 생성할 때는 class 속성을 사용한다.
    map1 = new java.util.HashMap();
    request.setAttribute("map1",map1);
  }</pre>
	<%
	  request.setAttribute("str1", new String("홍길동"));
	%>
	<jsp:useBean id="map1" type="java.util.Map" class="java.util.HashMap"
		scope="request" />
	<%=map1%>
</body>
</html>
