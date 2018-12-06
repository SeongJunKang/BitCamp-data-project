<%@page import="bitcamp.pms.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<title>게시판 EL</title>
</head>
<body>
	<h1>게시판 - 상세정보</h1>
	<form action='update.do' method='post'>
	  <jsp:useBean id="board" type="bitcamp.pms.vo.Board" scope="request" />
		<input type='hidden' name='no' value='${board.no}'> 
		제목 : <input type='text' name='title' value='${board.title}'><br>
		내용 : <textarea name='content' rows='5' cols='60'>${board.content}</textarea><br>
		<button>변경</button>
		<a href='delete.do?no=${board.no}' style="margin-right: 10px;">삭제</a>
		<a href='list.do'>목록</a>
		<button type='reset'>초기화</button>
	</form>
	<jsp:include page="../common/Copyright.jsp"/>
</body>
</html>
