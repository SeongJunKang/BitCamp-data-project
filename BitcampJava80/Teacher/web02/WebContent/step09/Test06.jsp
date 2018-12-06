<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<jsp:include page="../step07/BasicStyle.jsp"/>
</head>
<body>
<h1>JSTL 사용법 : Core 라이브러리</h1>

<h2>c:forEach</h2>
<pre>
=> 반복문을 생성하는 태그. 
# 문법
&lt;c:forEach var="변수명" items="목록데이터" begin="시작인덱스" end="종료인덱스">
  콘텐츠
&lt;/c:forEach>
=> 목록데이터는 EL을 사용하여 지정한다.
=> items에 지정할 수 있는 객체 타입
   배열, Collection, Iterator, Enumeration, Map, 콤마(,)로 구분되는 문자열

# 사용 예
<%
pageContext.setAttribute("names", 
    new String[]{"홍길동","임꺽정","이순신","권율","안중근","윤봉길","유관순"});
%>
</pre>
<ul>
  <c:forEach var="n" items="${names}" begin="2" end="5">
  <li>${n}</li>
  </c:forEach>
</ul>
<hr>

<ul>
  <c:forEach var="n2" items="${'aaa,bbb,ccc,ddd,eee,fff,ggg,hhh,iii'}">
  <li>${n2}</li>
  </c:forEach>
</ul>
</body>
</html>







