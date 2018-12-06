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
	<h1>EL 사용법 : 파라미터 값 꺼내기</h1>
	<pre>
문법) 
\${param.파라미터명} : request.getParameter("파라미터명");
\${paramValues.파라미터명} : request.getParameterValues("파라미터명");
예) http://localhost:8080/web02/step08/Test04.jsp?name=abc&email=lalal&tel=111
name=${param.name}
name 배열=${paramValues.name}
email=${param.email}
tel=${param.tel}
</pre>

<a href="Test05.jsp">Test05.jsp 요청</a>

</body>
</html>
