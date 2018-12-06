<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>page3</h1>
<form action="page4.do" method="post">
이름: ${sessionScope.name}<br>
나이: ${sessionScope.age}<br>
전화: ${sessionScope.tel}<br>
이메일: ${sessionScope.email}<br>
팩스: ${sessionScope.fax}<br>
<button>완료</button>
</form>
</body>
</html>