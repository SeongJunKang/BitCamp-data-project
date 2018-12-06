<%@page import="java.util.ArrayList"%>
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
	<h1>EL 기초문법 : List에서 값 꺼내기</h1>
	<%
	  ArrayList<String> nameList = new ArrayList<>();
	  nameList.add("홍길동");
	  nameList.add("임꺽정");
	  nameList.add("이순신");
	  pageContext.setAttribute("nameList",nameList);
	%>
	<pre>
# 리스트 값 출력 = 배열 값 꺼내는 것과 같다.
\${nameList[0]} = ${nameList[0]}
\${nameList[1]} = ${nameList[1]}
\${nameList[2]} = ${nameList[2]}

</pre>
</body>
</html>
