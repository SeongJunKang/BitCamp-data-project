<%@page import="bitcamp.pms.vo.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC >
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<h1>게시판 - 목록</h1>
	<p>
		<a href='new.do'>새 글</a> <a href='../auth/logout.do'
			style="margin-left: 5px">로그아웃</a> <a href='../member/list.do'
			style="margin-left: 5px">회원관리</a>
	</p>
	<table border='1'>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>등록일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="board" items="${boardlist}">
				<tr>
					<td>${board.no}</td>
					<td><a href='detail.do?no=${board.no}'>${board.title}</a></td>
					<td>${board.createdDate}</td>
					<td>${board.views}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<p>
		<a href='list.do?pageNo=${pageNo == 1?1:pageNo-1}&pageSize=${pageSize < 3 ? 3: pageSize > 20 ? 20:pageSize}'>이전 페이지</a>
		<a href='list.do?pageNo=${pageNo == totalPage ? totalPage : pageNo+1}&pageSize=${pageSize < 3 ? 3: pageSize > 20 ? 20:pageSize}'
			style="margin-left: 10px;">다음 페이지</a>
	</p>
	<jsp:include page="../common/Copyright.jsp" />
</body>
</html>
