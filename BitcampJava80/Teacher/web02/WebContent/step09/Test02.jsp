<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<h2>c:out</h2>
<pre>
=> 출력문을 만드는 태그이다.
# 문법
&lt;c:out value="출력할값" default="기본값"/>
&lt;c:out value="출력할값">기본값&lt;/c:out>

# 사용 예
=><c:out value="오호라..." default="하하하"/>
=><c:out value="${null}" default="하하하"/>
=><c:out value="${null}">하하하</c:out>
=><c:out value="${null}"/>

</pre>
</body>
</html>







