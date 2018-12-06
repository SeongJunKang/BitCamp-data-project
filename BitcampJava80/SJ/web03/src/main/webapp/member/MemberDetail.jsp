<%@page import="bitcamp.pms.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<title>회원관리</title>
</head>
<body>
	<h1>회원 - 상세정보</h1>
	<jsp:useBean id="member" type="bitcamp.pms.vo.Member" scope="request" />
	<form action='update.do' method='post'>
		<input type='hidden' name='no' value='${member.no}'> 이름 :
		<input type='text' name='name' value='${member.name}'><br>
		이메일 : <input type='email' name='email' value='${member.email}'><br>
		전화번호 : <input type='tel' name='tel'
			value=<%=member.getTel() == null ? "" : member.getTel()%>><br>
		<button>변경</button>
		<a href='delete.do?no=${member.no}' style="margin-right: 10px;">삭제</a>
		<a href='list.do'>목록</a>
		<button type='reset'>초기화</button>
	</form>
	<jsp:include page="../common/Copyright.jsp"/>
</body>
</html>

