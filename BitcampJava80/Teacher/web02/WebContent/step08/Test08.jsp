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
<h1>EL 기초 문법: List에서 값 꺼내기기</h1>
<%
ArrayList<String> nameList = new ArrayList<>();
nameList.add("홍길동");
nameList.add("임꺽정");
nameList.add("이순신");

pageContext.setAttribute("nameList", nameList);
%>
<pre>
# List 값 꺼내기 = 배열 값 꺼내는 것과 같다.
\${nameList[0]} => ${nameList[0]}
\${nameList[2]} => ${nameList[2]}
\${nameList[3]} => ${nameList[3]}



</pre>

</body>
</html>







