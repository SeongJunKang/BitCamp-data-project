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
	<h1>JSTL 사용법 : 개요</h1>
	<ul>
		<li>JSP Standard Tag Library 약자이다.
		<li>JSP 확장 라이브러리이다. 따라서 별도로 다운로드 해야한다.
		<li>
	</ul>
	<h2>JSP 페이지에 JSTL 라이브러리 사용하기</h2>
	<pre>
# JSTL 라이브러리
Core: http://java.sun.com/jsp/jstl/core
XML: http://java.sun.com/jsp/jstl/xml
Internationalization: http://java.sun.com/jsp/jstl/fmt
SQL: http://java.sun.com/jsp/jstl/sql
Functions: http://java.sun.com/jsp/jstl/functions
	
#taglib 지시어를 사용하여 JSTL 라이브러리를 임포트한다.
&lt;%@ taglib uri="라이브러리 네임스페이스 명" prefix="별명"%>

예) core 라이브러리 임포트
&lt;%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
예) xml 라이브러리 임포트
&lt;%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
예) I18N 라이브러리 임포트
&lt;%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
예) sql 라이브러리 임포트
&lt;%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
예) Functions 라이브러리 임포트
&lt;%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	</pre>
</body>
</html>

