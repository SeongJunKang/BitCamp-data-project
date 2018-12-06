<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<jsp:include page="../step07/BasicStyle.jsp"/>
</head>
<body>
<h1>EL 기초 문법: 표현식</h1>
<pre>
# 값 출력
\${"오호라"} => ${"오호라"}
\${'오호라'} => ${'오호라'}
\${20} => ${20}
\${20.345} => ${20.345}
\${true} => ${true}
\${null} => ${null}

</pre>

</body>
</html>







