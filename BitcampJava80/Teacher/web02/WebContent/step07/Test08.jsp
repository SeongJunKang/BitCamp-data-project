<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<h1>JSP 액션 태그 - jsp:useBean</h1>
<ul>
  <li>JSP 액션 태그란? JSP 페이지에서 사용할 수 있는 전용 태그이다.
  <li>각 태그는 고유의 자바 코드로 변환된다.
  <li>자바 객체를 생성하여 보관소에 저장하는 기능.
  <li>보관소: ServletContext, HttpSession, ServletRequest, PageContext
</ul>

<%-- String 객체를 생성하고 보관해보자. 
id => 객체를 보관소에 저장할 때 사용할 이름 및 레퍼런스 명.
class => 생성할 객체의 타입
scope => 보관소. 이 속성을 생략하면 PageContext(page)이다.
보관소 이름 => ServletContext(application), HttpSession(session)
               ServletRequest(requst), PageContext(page)
--%>
<jsp:useBean id="str1" class="java.lang.String" scope="application"></jsp:useBean>
<jsp:useBean id="str2" class="java.lang.String" scope="session"></jsp:useBean>
<jsp:useBean id="str3" class="java.lang.String" scope="request"></jsp:useBean>
<jsp:useBean id="str4" class="java.lang.String" scope="page"></jsp:useBean>

<%
// 보관소에 저장된 객체를 꺼내보기
String r1 = (String)application.getAttribute("str1");
String r2 = (String)session.getAttribute("str2");
String r3 = (String)request.getAttribute("str3");
String r4 = (String)pageContext.getAttribute("str4");
String r5 = (String)pageContext.getAttribute("str5");
%>
<%=r1%>, <%=r2%>, <%=r3%>, <%=r4%>, <%=r5%><br>
</body>
</html>










