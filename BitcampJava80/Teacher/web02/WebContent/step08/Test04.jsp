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
<h1>EL 사용법: 파라미터 값 꺼내기</h1>

<pre>
문법)
\${param.파라미터명} : request.getParameter("파라미터명");
\${paramValues.파라미터명} : request.getParameterValues("파라미터명");

예) http://localhost:8080/web03/step08/Test04.jsp?name=xxx&email=xxx&tel=xxxx
name=${param.name}
name 배열=${paramValues.name}
email=${param.email}
tel=${param.tel}
</pre>

<a href="Test05.jsp">Test05.jsp 요청</a>
</body>
</html>







