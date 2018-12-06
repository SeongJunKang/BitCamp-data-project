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
<h1>EL 기초 문법: 논리 연산자 사용법</h1>
<pre>
\${true && false} => ${true && false}
\${true and false} => ${true and false}
\${true || false} => ${true || false}
\${true or false} => ${true or false}
\${!true} => ${!true}
\${not true} => ${not true}
</pre>

</body>
</html>







