<%@page import="bitcamp.pms.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC >
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<h1>게시판 - 새 글</h1>
	<p>* 항목은 필수 항목입니다.</p>
	<form action='add.do' method='post'>
		* 제목 : <input type='text' name='title'><br> 
		* 내용 : <textarea name='content' rows='5' cols='60'></textarea><br>
		 비밀번호 : <input type='password' name='password'><br>
		<button>게시물 등록</button>
		<a href='list.do' style="margin-right: 10px;">목록</a>
		<button type='reset'>초기화</button>
	</form>
	<jsp:include page="../common/Copyright.jsp"/>
</body>
</html>
