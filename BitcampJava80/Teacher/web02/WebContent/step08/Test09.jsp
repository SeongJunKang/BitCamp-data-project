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
<h1>EL 기초 문법: Map에서 값 꺼내기</h1>
<%
HashMap<String,String> map = new HashMap<>();
map.put("s01", "홍길동");
map.put("s02", "임꺽정");
map.put("s03", "이순신");

pageContext.setAttribute("map", map);
%>
<pre>
# Map 값 꺼내기
\${map.s01} => ${map.s01}
\${map["s01"]} => ${map["s01"]}
\${map.s02} => ${map.s02}
\${map.s03} => ${map.s03}



</pre>

</body>
</html>







