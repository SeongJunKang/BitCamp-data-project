<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
int i = 10;
int j = 20;
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>표현식(expression element)</h1>
	<ul>
		<li>_jspService() 메서드 안에 출력문으로 변환되어 들어간다.
		<li>태그 안의 자바 코드가 그대로 출력문의 파라미터 자리에 놓인다.
		<li>예)sum=<%=i+j%><br>
	</ul>
	<%--
	# JSP 주석.
	=>클라이언트로 출력되지 않는다.
	# 표현식
	=> <%= 자바코드 %> ---> out.print(자바코드);
	=> out.print()의 파라미터 자리에 올 수 있는 자바 코드는 모두 가능하다.
	 --%>
	<!--
	html 주석 이므로 템플릿 데이터이다.
	그러므로 그대로 출력된다. 
	 -->
</body>
</html>