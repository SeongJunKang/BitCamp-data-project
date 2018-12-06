<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" buffer="8kb" autoFlush="true"
	trimDirectiveWhitespaces="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<jsp:include page="../step07/BasicStyle.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>JSTL 사용법 : Core 라이브러리</h1>
	<h2>c:forEach</h2>
	<pre>
  => 반복문을 생성 태그
  # 문법
  &lt;c:forEach var="변수명"  items="목록데이터" begin="시작인덱스" end="종료인덱스">
    콘텐츠
  &lt;/c:forEach>
  => 목록데이터는 EL 을 사용한다.
  => items에 지정할 수 있는 객체 타입
     => 배열, Collection, Iterator, Enumeration, Map, 콤마로 구분되는 문자열
  
  # 사용 예
  <%
	  pageContext.setAttribute("names", 
	      new String[] { "홍길동", "임꺽정", "이순신","권율","안중근","윤봉길"});
	%>
	</pre>
	<ul>
	 <c:forEach var="name" items="${names}"  begin="1" end="4">
    <li>${name}</li>	 
	 </c:forEach>
	</ul>
	<hr>
	<ul>
   <c:forEach var="name" items="${'aaa,bbb,ccc,ddd,eee,fff,ggg,hhh,iii,jjj,kkk'}" >
    <li>${name}</li>   
   </c:forEach>
  </ul>
</body>
</html>

