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
	<h1>EL 기초문법 : Map에서 값 꺼내기</h1>
	<%
	  HashMap<String,String> map = new HashMap<>();
	  map.put("s1","홍길동");
	  map.put("s2","임꺽정");
	  map.put("s3","이순신");
	  pageContext.setAttribute("map",map);
	%>
	<pre>
# 맵 값 꺼내기.
\${map.s1} = ${map.s1}
\${map.s2} = ${map.s2}
\${map["s3"]} = ${map["s3"]}

</pre>
</body>
</html>
