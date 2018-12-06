<%@page import="bitcamp.pms.vo.Board"%>
<%@page import="java.util.List"%>
<%@ page 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
<h1>게시판-목록</h1>
<p><a href='add.do'>새 글</a></p>
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
<c:forEach items="${list}" var="board">
<tr>
  <td>${board.no}</td>
  <td><a href='detail.do?no=${board.no}'>${board.title}</a></td>
  <td>${board.createdDate}</td>
  <td>${board.views}</td>
</tr>
</c:forEach>
</tbody>
</table>
<jsp:include page="../common/Copyright.jsp"/>
</body>
</html>








