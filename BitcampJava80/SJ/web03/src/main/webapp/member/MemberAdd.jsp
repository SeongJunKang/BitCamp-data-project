<%@page import="bitcamp.pms.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원</title>
</head>
<body>
	<h1>회원 - 등록</h1>
	<p>* 항목은 필수 항목입니다.</p>
	<form action='add.do' method='post'>
		* 이름 : <input type='text' name='name'><br> 
		* 이메일 : <input	type='email' name='email'><br> 
		* 비밀번호 : <input	type='password' name='password'><br> 
		전화번호 : <input	type='tel' name='tel' placeholder='ex) 123-1234 또는 010-1234-1234'><br>
		<button>회원 등록</button>
		<a href='list.do' style="margin-right: 10px;">목록</a>
		<button type='reset'>초기화</button>
	</form>
</body>
</html>
