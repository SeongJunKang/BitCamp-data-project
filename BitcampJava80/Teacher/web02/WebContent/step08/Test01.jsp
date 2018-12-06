<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<jsp:include page="../step07/BasicStyle.jsp"/>
</head>
<body>
<h1>EL 사용법 - 개요</h1>
<ul>
  <li>Expression Language의 약자이다.
  <li>OGNL(Object-Graph Navigation Language) 표기법을 이용하여 객체의 프로퍼티 값을 다룬다.
  <li>getter/setter 사용을 쉽게 도와주는 표기법
</ul>

<h2>EL 기본 문법</h2>
<pre>
\${객체명.프로퍼티명.프로퍼티명.프로퍼티명}
\${객체명["프로퍼티명"]["프로퍼티명"]["프로퍼티명"]}
</pre>
</body>
</html>







