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
	<h1>EL 기초문법 : 배열에서 값 꺼내기</h1>
	<%
	  pageContext.setAttribute("names", new String[] {"홍길동","임꺽정","이순신"});
	%>
	<pre>
# 배열 값 출력
\${names[0]} = ${names[0]}
\${names[1]} = ${names[1]}
\${names[2]} = ${names[2]}

# 없는 값 출력
\${names[3]} = ${names[3]}
</pre>
</body>
</html>
