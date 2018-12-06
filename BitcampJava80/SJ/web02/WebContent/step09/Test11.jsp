<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" buffer="8kb" autoFlush="true"
	trimDirectiveWhitespaces="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<jsp:include page="../step07/BasicStyle.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>JSTL 사용법 : I18N 라이브러리</h1>
	<h2>fmt:formatDate</h2>
	<pre>
  => java.util.Date 객체를 지정한 형식의 문자열로 변환할 떄 사용  
  # 문법
  &lt;fmt:formatDate value="날짜" pattern="출력패턴"/>
  => 날짜는 EL을 사용하여 지정한다.
  => 패턴은 문자열로 지정한다.
  
  # 사용 예
  <% pageContext.setAttribute("today",new Date());%>
  </pre>
  오늘 날짜 : <fmt:formatDate value="${today}" pattern="yyyy-MM-dd"/><br>
  오늘 날짜 : <fmt:formatDate value="${today}" pattern="MM/dd/yyyy"/>
</body>
</html>

