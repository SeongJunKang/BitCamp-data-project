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

<h2>c:import</h2>
<pre>
=> HTTP 요청을 수행하는 태그.  
# 문법
&lt;c:import url="URL" var="변수명" scope="page|request|session|application"/>
=> 변수명을 지정하면 보관소에 그 변수 이름을 결과를 저장한다.
=> 변수명을 지정하지 않으면 응답 결과를 그 자리에 놓는다.

# 사용 예
<c:import url="http://www.naver.com" var="result"/>
</pre>
<textarea rows="10" cols="80">${result}</textarea>
<textarea rows="10" cols="80"><c:import url="http://www.daum.net"/></textarea>
</body>
</html>







