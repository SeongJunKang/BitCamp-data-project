<%@page import="bitcamp.pms.vo.Member"%>
<%@page import="java.util.List"%>
<%@ page 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
</head>
<body>
<h1>회원-목록</h1>
<p><a href='add.do'>새 회원</a></p>
<table border='1'>
<thead>
<tr>
  <th>번호</th>
  <th>이름</th>
  <th>이메일</th>
  <th>전화</th>
</tr>
</thead>
<tbody>

<c:forEach var="member" items="${list}">
<tr>
  <td>${member.no}</td>
  <td><a href='detail.do?no=${member.no}'>${member.name}</a></td>
  <td>${member.email}</td>
  <td>${member.tel}</td>
</tr>
</c:forEach>

</tbody>
</table>
<jsp:include page="../common/Copyright.jsp"/>
</body>
</html>








