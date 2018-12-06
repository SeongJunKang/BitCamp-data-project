<%@page import="bitcamp.pms.vo.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" 
  contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"
	%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC >
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
</head>
<body>
	<h1>회원 - 목록</h1>
	<p>
		<a href='new.do'>회원 등록</a>
    <a href='../auth/logout.do' style="margin-left: 10px">로그아웃</a>
    <a href='../board/list.do' style="margin-left: 10px">게시판</a>
	</p>
	<table border='1'>
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>이메일</th>
				<th>전화번호</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="member" items="${memberlist}">
			<tr>
				<td>${member.no}</td>
				<td><a href='detail.do?no=${member.no}'>${member.name}</a></td>
				<td>${member.email}</td>
				<td>${member.tel}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<p>
	<a href='list.do?pageNo=${pageNo == 1?1:pageNo-1}&pageSize=${pageSize}'>이전</a>
  <a href='list.do?pageNo=${pageNo+1}&pageSize=${pageSize}' style="margin-left: 10px;">다음</a>
  </p>
	<jsp:include page="../common/Copyright.jsp"/>
</body>
</html>
