<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" buffer="8kb" autoFlush="true"
	trimDirectiveWhitespaces="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../step07/BasicStyle.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>EL 기초문법 : empty와 조건 연산자 사용법</h1>
	<%
	pageContext.setAttribute("name","홍길동");
	%>
<pre>
=> null 인지 아닌지 검사할 때 사용한다.
\${empty name} => ${empty name}
\${empty name2} => ${empty name2}
\${10 >20 ? "크다" :"작다" } => ${10 >20 ? "크다" :"작다"}

</pre>
</body>
</html>

