<%@page import="java.util.Date"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<jsp:include page="../step07/BasicStyle.jsp"/>
</head>
<body>
<h1>JSTL 사용법 : i18n 라이브러리</h1>

<h2>fmt:formatDate</h2>
<pre>
=> java.util.Date 객체를 지정한 형식의 문자열로 변환할 때 사용. 
# 문법
&lt;fmt:formatDate value="날짜" pattern="출력패턴"/>
=> 날짜는 EL을 사용하여 지정한다.
=> 출력패턴은 문자열로 지정한다.

# 사용 예
<% pageContext.setAttribute("today", new Date()); %>
오늘 날짜: <fmt:formatDate value="${today}" pattern="yyyy-MM-dd"/>
오늘 날짜: <fmt:formatDate value="${today}" pattern="MM/dd/yyyy"/>
</pre>
</body>
</html>







