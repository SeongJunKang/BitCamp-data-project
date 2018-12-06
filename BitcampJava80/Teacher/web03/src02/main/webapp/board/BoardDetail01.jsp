<%@page import="bitcamp.pms.vo.Board"%>
<%@ page 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// ServletRequest 보관소에 저장된 게시물을 꺼낸다.
Board board = (Board)request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<title>게시판(by JSP)</title>
</head>
<body>
<h1>게시판-상세정보</h1>
<form action='update.do' method='post'>
<input type='hidden' name='no' value='<%=board.getNo()%>'>
제목: <input type='text' name='title' value='<%=board.getTitle()%>'><br>
내용: <textarea name='content' rows='5' cols='60'><%=board.getContent()%></textarea><br><button>변경</button>
<a href='delete.do?no=<%=board.getNo()%>'>삭제</a><button type='reset'>초기화</button>
</form>
<jsp:include page="../common/Copyright.jsp"/>
</body>
</html>
