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
<h1>JSTL 사용법 : 개요</h1>
<ul>
  <li>JSP Standard Tag Library 약자이다.
  <li>JSP 확장 라이브러리이다. 따라서 별도로 다운로드해야 한다.
</ul>

<h2>JSP 페이지에 JSTL 라이브러리 사용하기</h2>
<pre>
# JSTL 라이브러리
Core: http://java.sun.com/jsp/jstl/core
XML: http://java.sun.com/jsp/jstl/xml
Internationalization: http://java.sun.com/jsp/jstl/fmt
SQL: http://java.sun.com/jsp/jstl/sql
Functions: http://java.sun.com/jsp/jstl/functions

# taglib 지시어를 사용하여 JSTL 라이브러리를 임포트한다.
&lt;%@ taglib uri="라이브러리 네임스페이스 명" prefix="별명" %>

예) Core 라이브러리 임포트
&lt;%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

예) XML 라이브러리 임포트
&lt;%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>

예) I18N 라이브러리 임포트
&lt;%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

예) SQL 라이브러리 임포트
&lt;%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

예) Functions 라이브러리 임포트
&lt;%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
</pre>
</body>
</html>







