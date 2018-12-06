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
	<h1>EL 기초문법 : 표현식</h1>
	<pre>
# 값 출력
\${"오호라"} : ${"오호라"}
\${'오호라'} : ${'오호라'}
\${20} : ${20}
\${20.345} :S ${20.345}
\${true} : ${true}
\${null} : ${null}
</pre>
</body>
</html>
