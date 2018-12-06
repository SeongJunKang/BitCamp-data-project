<%@page import="bitcamp.pms.vo.Member"%>
<%@page import="java.util.List"%>
<%@ page 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리(by JSP)</title>
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
<jsp:useBean id="list" type="java.util.List<Member>" scope="request"/>
<%
for (Member member : list) {%>
<tr>
  <td><%=member.getNo()%></td>
  <td><a href='detail.do?no=<%=member.getNo()%>'><%=member.getName()%></a></td>
  <td><%=member.getEmail()%></td>
  <td><%=member.getTel()%></td>
</tr>
<%} %>
</tbody>
</table>
<jsp:include page="../common/Copyright.jsp"/>
</body>
</html>








