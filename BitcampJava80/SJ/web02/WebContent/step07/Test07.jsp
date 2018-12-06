<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" buffer="8kb" autoFlush="true"
	trimDirectiveWhitespaces="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>지시문(directive element) - include</h1>
	<ul>
		<li>다른 파일의 내용을 가져와서 삽입할 때 사용한다.
		<li>include를 실행한 후 서블릿 자바 코드로 변환한다.
	</ul>
	<%
	  int i = 10;
	  int j = 15;
	%>
	<%@ include file="footer.txt"%>
</body>
</html>
