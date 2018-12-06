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
	<h1>EL 사용법 : 보관소명 생략하기</h1>
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
	  request.setAttribute("car", car);
	%>
	<h2>EL 기본 문법</h2>
	<pre>
1.보관소명 생략
\${객체이름} : pageContext.findAttribute("객체이름")

2.보관소명을 생략하면 다음 순서로 객체를 찾는다.
  1)PageContext 2)ServletRequest 3)HttpSession 4)ServletContext 

자바코드 :
Car car = pageContext.getAttribute("car");
if (car == null) {
  car = request.getAttribute("car");
  if (car == null) {
    car = session.getAttribute("car");
    if(car == null) {
      car = application.getAttribute("car");  
    }
  } 
}

2.예
\${car.engine.cc => ${car.engine.cc}  : requestScope 생략
</pre>
</body>
</html>
