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
<h1>JSP 액션 태그 - jsp:useBean 사용법4</h1>
<h2>use:Bean vs Java code</h2>
<p>
&lt;jsp:useBean id="map1" 
             type="java.util.HashMap" 
             scope="request"/>
</p>
<pre>
// 보관소에서 값을 꺼내기만 할 때는 class를 생략한다.
java.util.HashMap map1 = (java.util.HashMap)request.getAttribute("map1");
if (map1 == null) {
  // class 속성이 없으면, 객체를 생성하지 않는다.
  // 보관소에 id로 객체를 찾을 수 없으면 예외를 띄운다.
  throw new InstantiationException();
}
</pre>

<jsp:useBean id="map1" 
             type="java.util.HashMap" 
             scope="request"/>


</body>
</html>










