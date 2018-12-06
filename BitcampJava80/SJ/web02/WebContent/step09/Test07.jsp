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
	<h2>c:forToken</h2>
	<pre>
  => 문자열을 지정된 구분자를 사용하여 분리할 때 사용한다.  
  # 문법
  &lt;c:forToken var="변수명"  items="문자열" delims="구분문자" >
    콘텐츠
  &lt;/c:forToken>
  => 문자열은 EL 을 사용하여 지정한다.  
  
  # 사용 예
  <%
	  pageContext.setAttribute("params","name=aaa&age=20&tel=111-2222");
	%>
	</pre>
	<ul>
		<c:forTokens var="p" items="${params}" delims="&">
			<li>${p}</li>
		</c:forTokens>
	</ul>
</body>
</html>

