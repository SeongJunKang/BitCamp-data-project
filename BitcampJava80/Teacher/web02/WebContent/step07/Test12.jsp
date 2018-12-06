<%@page import="java.util.HashMap"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<jsp:include page="BasicStyle.jsp"/>
</head>
<body>
<h1>JSP 액션 태그 - jsp:include, jsp:forward</h1>
<p>
&lt;%@ include file="파일"%>, 해당 파일을 현 위치에 그대로 가져온다는 것이다.<br>
&lt;jsp:include page="서블릿 또는 JSP 경로"/>, 해당 경로의 서블릿 또는 JSP를 실행한다.<br>
따라서 jsp:include의 page 속성 값은 반드시 서블릿 또는 JSP 경로여야 한다. 
</p>
<h2>use:Bean vs Java code</h2>
<p>
&lt;jsp:include page="BasicStyle.jsp"/>
</p>
<pre>
RequestDispatcher rd = request.getRequestDispatcher("BasicStyle.jsp");
rd.include(request, response);
</pre>
</body>
</html>










