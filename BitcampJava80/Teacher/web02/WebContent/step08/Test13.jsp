<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
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
<h1>EL 기초 문법: empty와 조건 연산자 사용법</h1>
<%
pageContext.setAttribute("name", "홍길동");
%>
<pre>
=> null인지 아닌지 검사할 때 사용한다.
\${empty name} => ${empty name}
\${empty name2} => ${empty name2}
\${10 > 20 ? "크다": "작다"} => ${10 > 20 ? "크다": "작다"}
</pre>

</body>
</html>







