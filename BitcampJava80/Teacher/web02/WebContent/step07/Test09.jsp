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
<h1>JSP 액션 태그 - jsp:useBean 사용법2</h1>
<h2>객체 생성 절차</h2>
<ol>
  <li>보관소에 id 값으로 저장된 객체를 찾는다.
  <li>있다면, 그 객체를 리턴한다.
  <li>없다면, 그 객체를 생성하여 보관소에 저장한다.
</ol>
<h2>use:Bean vs Java code</h2>
<p>
&lt;jsp:useBean id="str1" class="java.lang.String" scope="request"/>
</p>
<pre>
String str1 = (String)request.getAttribute("str1");
if (str1 == null) {
  str1 = new String();
  request.setAttribute("str1", str1);
}
</pre>

<% //1) 보관소에 객체 있는 경우
request.setAttribute("str1", "홍길동");
%>
<jsp:useBean id="str1" class="java.lang.String" scope="request"></jsp:useBean>
<jsp:useBean id="str2" class="java.lang.String" scope="request"></jsp:useBean>

<%
// 보관소에 저장된 객체를 꺼내보기
String r1 = (String)request.getAttribute("str1");
String r2 = (String)request.getAttribute("str2");
%>
보관소에 들어 있는 객체: <%=r1%><br> 
보관소에 없어서 새로 만든 객체: <%=r2%><br>

</body>
</html>










