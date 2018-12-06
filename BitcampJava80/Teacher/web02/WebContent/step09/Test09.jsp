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

<h2>c:redirect</h2>
<pre>
=> redirect 코드를 생성하는 태그.
# 문법
&lt;c:redirect url="URL"/>

# 사용 예
<c:choose>
  <c:when test="${param.site=='daum'}">
    <c:redirect url="http://www.daum.net"/>
  </c:when>
  <c:when test="${param.site=='naver'}">
    <c:redirect url="http://www.naver.com"/>
  </c:when>
  <c:otherwise>
    유효하지 않는 사이트입니다.
  </c:otherwise>
</c:choose>
</body>
</html>







