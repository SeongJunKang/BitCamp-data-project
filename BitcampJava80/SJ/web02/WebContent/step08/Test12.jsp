<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" buffer="8kb" autoFlush="true"
	trimDirectiveWhitespaces="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../step07/BasicStyle.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>EL 기초문법 : 비교 연산자 사용법</h1>
<pre>
\${10 == 20} => ${10 == 20}
\${10 eq 20} => ${10 eq 20}
\${10 != 20} => ${10 != 20}
\${10 ne 20} => ${10 ne 20}
\${10 < 20} => ${10 < 20}
\${10 lt 20} => ${10 lt 20}
\${10 > 20} => ${10 > 20}
\${10 gt 20} => ${10 gt 20}
\${10 <= 20} => ${10 <= 20}
\${10 le 20} => ${10 le 20}
\${10 >= 20} => ${10 >= 20}
\${10 ge 20} => ${10 ge 20}

</pre>
</body>
</html>
