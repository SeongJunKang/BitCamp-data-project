<%@ page 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>게시판</title>
</head>
<body>
<h1>게시판-상세정보</h1>
<form action='update.do' method='post'>
<input type='hidden' name='no' value='${board.no}'>
제목: <input type='text' name='title' value='${board.title}'><br>
내용: <textarea name='content' rows='5' cols='60'>${board.content}</textarea><br><button>변경</button>
<a href='delete.do?no=${board.no}'>삭제</a><button type='reset'>초기화</button>
</form>
<jsp:include page="../common/Copyright.jsp"/>
</body>
</html>
