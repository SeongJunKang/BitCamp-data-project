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
<h1>EL 기초 문법: 관계 연산자 사용법</h1>
<pre>
\${10 == 20} => ${10 == 20}
\${10 eq 20} => ${10 eq 20}
\${10 != 20} => ${10 != 20}
\${10 ne 20} => ${10 ne 20}
\${10 < 20} => ${10 < 20}
\${10 lt 20} => ${10 lt 20}
\${10 > 20} => ${10 > 20}
\${10 gt 20} => ${10 gt 20}
\${10 <= 20} => ${10 <= 20}
\${10 le 20} => ${10 le 20}
\${10 >= 20} => ${10 >= 20}
\${10 ge 20} => ${10 ge 20}
</pre>

</body>
</html>







