<%@page import="bitcamp.pms.vo.Member"%>
<%@ page 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Member member = (Member)request.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<title>회원관리(by JSP)</title>
</head>
<body>
<h1>회원관리-상세정보</h1>
<form action='update.do' method='post'>
번호: <input type='text' name='no' value='<%=member.getNo()%>' readonly><br>
이름: <input type='text' name='name' value='<%=member.getName()%>'><br>
이메일: <input type='text' name='email' value='<%=member.getEmail()%>'><br>
암호: <input type='password' name='password'><br>
전화: <input type='text' name='tel' value='<%=member.getTel()%>'><br>
<button>변경</button>
<a href='delete.do?no=<%=member.getNo()%>'>삭제</a><button type='reset'>초기화</button>
</form>
<jsp:include page="../common/Copyright.jsp"/>
</body>
</html>
