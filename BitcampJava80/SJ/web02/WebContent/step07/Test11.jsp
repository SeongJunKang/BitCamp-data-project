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
	<h1>JSP 액션 태그 - jsp:useBean 사용법4</h1>
	<h2>use:Bean vs Java code</h2>
	<ol>
		<li>보관소에 id 값으로 저장된 객체를 찾는다.
		<li>있다면, 그 객체(주소)를 리턴한다.
		<li>없다면, 그 객체를 생성하여 보관소에 저장한다.
	</ol>
	<p>&lt;jsp:useBean id="map1" type="java.util.HashMap"
		class="java.lang.HashMap" scope="request"/></p>
	<pre>
  // 보관소에서 값을 꺼내기만 할 때는 class를 생략한다.
  java.util.HashMap map1 = (java.util.HashMap)request.getAttribute("map1");
  if (map1 == null) {
    // class 속성이 없으면, 객체를 생성하지 않는다.
    // 보관소에 id로 객체를 찾을 수 없으면 예외를 띄운다.
    throw new InstantiationException();
  }</pre>
	<%-- 클래스는 빈객체라도 생성하지만 타입은 객체 생성을 하지 않는다. --%>
	<jsp:useBean id="map1" type="java.util.HashMap" scope="request" />
	<%=map1%>
</body>
</html>
