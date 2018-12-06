<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<h1>지시문(directive element) - include</h1>
<ul>
  <li>다른 파일의 내용을 가져와서 삽입할 때 사용한다.
  <li>include를 실행한 후, 서블릿 자바 코드로 변환한다.
</ul>
<%
int i = 10; 
int j = 20;
%>
<%@ include file="footer.txt" %>
</body>
</html>










