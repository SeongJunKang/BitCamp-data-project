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

<h2>c:choose</h2>
<pre>
=> 조건에 따라 여러 개로 분기되는 코드 생성.
# 문법
&lt;c:choose>
 &lt;c:when test="조건식">콘텐츠&lt;/c:when>
 &lt;c:when test="조건식">콘텐츠&lt;/c:when>
 &lt;c:when test="조건식">콘텐츠&lt;/c:when>
 ...
 &lt;c:otherwise>콘텐츠&lt;/c:otherwise>
&lt;/c:otherwise>
=> 조건식은 EL을 사용한다.

# 사용 예
<c:set var="age" value="-18"/>

<c:choose>
  <c:when test="${age >= 0 && age < 19}">미성년입니다.</c:when>
  <c:when test="${age >= 19 && age < 65}">성년입니다.</c:when>
  <c:when test="${age >= 65}">노인입니다.</c:when>
  <c:otherwise>나이 값이 옳지 않습니다.</c:otherwise>
</c:choose>

</pre>

</body>
</html>







