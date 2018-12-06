<%@ page 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>회원관리</title>
</head>
<body>
<h1>회원관리-새 회원</h1>
<form action='add.do' method='post'>
이름: <input type='text' name='name'><br>
이메일: <input type='text' name='email'><br>
암호: <input type='password' name='password'><br>
전화: <input type='text' name='tel'><br>
<button>등록</button>
<button type='reset'>초기화</button>
</form>
<jsp:include page="../common/Copyright.jsp"/>
</body>
</html>

