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

<h2>c:forTokens</h2>
<pre>
=> 문자열을 지정된 구분자를 사용하여 분리할 때 사용.  
# 문법
&lt;c:forTokens var="변수명" items="문자열" delims="구분자">
  콘텐츠
&lt;/c:forTokens>
=> 문자열은 EL을 사용하여 지정한다.

# 사용 예
<%
pageContext.setAttribute("params", "name=aaa&age=20&tel=111-2222");
%>
</pre>
<ul>
  <c:forTokens var="p" items="${params}" delims="&">
  <li>${p}</li>
  </c:forTokens>
</ul>
</body>
</html>







