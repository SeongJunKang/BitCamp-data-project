<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h1>로그인</h1>
	<form action='login.do' method='post'>
		이메일(id) : <input type='text' name='email' value='${email}'><br>
		비밀번호 : <input type='password' name='password'><br> 
		<input type='checkbox' name='emailsave' ${checked}>email 저장<br>
		<button>로그인</button>
	</form>
</body>
</html>