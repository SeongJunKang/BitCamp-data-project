<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" buffer="8kb" autoFlush="true"
	trimDirectiveWhitespaces="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP</title>
<style>
pre {
	background-color: lightgray;
}

p {
	background-color: orange;
}
</style>

</head>
<body>
	<h1>JSP 액션 태그 - jsp:useBean 사용법2</h1>
	<h2>객체 생성 절차</h2>
	<ol>
		<li>보관소에 id 값으로 저장된 객체를 찾는다.
		<li>있다면, 그 객체(주소)를 리턴한다.
		<li>없다면, 그 객체를 생성하여 보관소에 저장한다.
	</ol>
	<h2>use:Bean vse Java code</h2>
	<p>&lt;jsp:useBean id="str1" class="java.lang.String"
		scope="request"/></p>
	<pre>
  String str1 = (String)request.getAttribute("str1");
  if (str1 == null) {
    str1 = new String();
    request.setAttribute("str1",str1);
  }
  </pre>
	<%
	  //보관소에 객체가 있는 경우 --
	  request.setAttribute("str1", new String("홍길동"));
	%>
	<jsp:useBean id="str1" class="java.lang.String" scope="request"/>
	<jsp:useBean id="str2" class="java.lang.String" scope="request"/>
	<%
	  String r1 = (String) request.getAttribute("str1");
	  String r2 = (String) request.getAttribute("str2");
	  String r3 = (String) application.getAttribute("str1");
	  String r4 = (String) session.getAttribute("str2");
	%>
	보관소에 있는 객체(request) :
	<%=r1%><br> 보관소에 없어서 새로 만든 객체(request) :
	<%=r2%><br> 보관소에 있는 객체(application) :
	<%=r3%><br> 보관소에 없는 객체(session) :
	<%=r4%><br>
</body>
</html>
