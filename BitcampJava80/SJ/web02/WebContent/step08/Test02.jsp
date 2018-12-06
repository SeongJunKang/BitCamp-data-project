<%@page import="step08.Car"%>
<%@page import="step08.Engine"%>
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
	<h1> EL 사용법 : 보관소에 저장된 객체의 프로퍼티 값 출력하기</h1>
	<%
	  //보관소에 값을 저장하자!
	  Engine engine = new Engine();
	  engine.setCc(3000);
	  engine.setValve(16);
	  engine.setMaker("비트자동차");
	  Car car = new Car();
	  car.setMaker("자바자동차");
	  car.setModel("씽씽이");
	  car.setCapacityt(5);
	  car.setSunroof(true);
	  car.setEngine(engine);
	  request.setAttribute("car",car);
	%>
	<ol>
		<li>Expression Language의 약자이다.
		<li>OGNL(Object Graph Navigation Language) 표기법을 이용하여 객체의 값을 다룬다.
		<li>getter/setter 사용을 쉽게 도와주는 표기법.
	</ol>
	<h2>EL 기본 문법</h2>
	<pre>
1.보관소에서 객체 꺼내기
\${보관소이름.객체이름}
ServletContext => applicationScope
HttpSession => sessionScope
ServletRequest => requestScope
PageContext => pageScope

2. ServletRequest 보관소에서 객체를 꺼내려면,
\${requestScope.객체이름} : request.getAttribute("객체이름");

	
\${requestScope.car.getMaker() => ${requestScope.car.getMaker()}  : 일반 자바 문법 사용
\${requestScope.car.maker => ${requestScope.car.maker}  : OGNL 표기법 사용

\${requestScope.car.getEngine().getCc() => ${requestScope.car.getEngine().getCc()} : 일반 자바 문법 사용
\${requestScope.car.engine.cc => ${requestScope.car.engine.cc}  : OGNL 표기법 사용

\${requestScope["car"]["maker"] => ${requestScope["car"]["maker"]}
\${requestScope["car"]["engine"] => ${requestScope["car"]["engine"]}
\${requestScope["car"]["engine"]["cc"] => ${requestScope["car"]["engine"]["cc"]}
</pre>
</body>
</html>
