<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" buffer="8kb" autoFlush="true"
	trimDirectiveWhitespaces="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../step07/BasicStyle.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>EL 사용법 - 개요</h1>
	<ol>
		<li>Expression Language의 약자이다.
		<li>OGNL(Object Graph Navigation Language) 표기법을 이용하여 객체의 값을 다룬다.
		<li>getter/setter 사용을 쉽게 도와주는 표기법.
	</ol>
	<h2>EL 기본 문법</h2>
	<pre>
\${객체명.프로퍼티명.프로퍼티명.프로퍼티명}
\${객체명["프로퍼티명"]["프로퍼티명"]["프로퍼티명"]}</pre>
</body>
</html>
