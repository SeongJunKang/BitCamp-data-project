<%@page import="java.util.HashMap"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<style>
pre {
  font-family: monospace;
  background-color: lightgray;
}
</style>
</head>
<body>
<h1>JSP 액션 태그 - jsp:useBean 사용법3</h1>
<h2>use:Bean vs Java code</h2>
<p>
&lt;jsp:useBean id="map1" 
             type="java.util.Map" 
             class="java.util.HashMap" 
             scope="request"/>
</p>
<pre>
// 레퍼런스 변수의 타입은 type 속성을 사용한다.
java.util.Map map1 = (java.util.Map)request.getAttribute("map1");
if (map1 == null) {
  // 객체를 생성할 때는 class 속성을 사용한다.
  map1 = new java.util.HashMap(); 
  request.setAttribute("map1", map1);
}
</pre>

<jsp:useBean id="map1" 
             type="java.util.Map" 
             class="java.util.HashMap" 
             scope="request"/>


</body>
</html>










