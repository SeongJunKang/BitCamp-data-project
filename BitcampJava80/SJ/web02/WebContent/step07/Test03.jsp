<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
  int i = 5;
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
  int j = 20;
  int sum = 0;
%>
<title>JSP</title>
</head>
<body>
	<%
	  sum = j + i;
	%>
	<h1>스크립트릿</h1>
	<ul>
		<li>자바 코드를 삽입시키는 JSP 태그이다
		<li>_jspService() 메서드 안에 선언된 순서대로 삽입된다.
		<li>작성한 코드가 그대로 복사된다.
	</ul>
	<%
	  out.println("sum :" + sum);
	%>
	<p>
		<%
		  String[] names = { "홍길동", "임꺽정", "이순신", "권율" };
		  for (String name : names) {
		    out.write(name);
		%>
		<br>
		<%
		  }
		%>
	</p>
</body>
</html>