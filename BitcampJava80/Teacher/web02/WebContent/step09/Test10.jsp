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

<h2>fmt:parseDate</h2>
<pre>
=> 문자열을 분석하여 java.util.Date 객체로 만드는 태그.
# 문법
&lt;fmt:parseDate var="변수명" value="문자열" pattern="패턴"/>
=> 변수명은 Date 객체를 저장할 때 사용할 이름.
=> 문자열은 보통 EL을 사용하여 지정한다. 하드 코딩할 때는 그냥 문자열을 넣어도 된다.
=> 패턴은 문자열로 value 속성의 날짜 형식을 지정한다.

# 사용 예
<fmt:parseDate var="d1" value="2016-5-16" pattern="yyyy-MM-dd"/>
<fmt:parseDate var="d2" value="5/16/2016" pattern="MM/dd/yyyy"/>

<%=pageContext.getAttribute("d1")%><br>
<%=pageContext.getAttribute("d2")%>
</pre>
</body>
</html>







