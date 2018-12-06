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
<h1>EL 기초 문법: 배열에서 값 꺼내기</h1>
<%
pageContext.setAttribute("names", new String[]{"홍길동","임꺽정","이순신"});
%>
<pre>
# 배열 값 꺼내기
\${names[0]} => ${names[0]}
\${names[2]} => ${names[2]}
\${names[3]} => ${names[3]}



</pre>

</body>
</html>







