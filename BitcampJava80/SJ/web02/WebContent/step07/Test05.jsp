<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>선언문(declaration element)</h1>
	<ul>
		<li>태그 안에 작성한 코드는 클래스의 블록 안에 복사된다.
		<li>클래스 멤버를 선언할 때 주로 사용한다.
		<li>10 + 20 = <%=plus(10,20) %>
	</ul>
</body>
</html>
<%!
//선언 태그 위치는 중요하지 않다.
//선언 태그 안에 있는 코드는 클래스의 블록안에 삽입되기 때문이다.
private int plus(int a, int b) {
  return a + b;
}
%>