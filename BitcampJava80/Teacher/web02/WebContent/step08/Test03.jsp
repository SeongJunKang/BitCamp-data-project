<%@page import="step08.Car"%>
<%@page import="step08.Engine"%>
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
<h1>EL 사용법: 보관소명 생략하기</h1>
<%
// 보관소에 값을 저장하자!
Engine engine = new Engine();
engine.setCc(3000);
engine.setValve(16);
engine.setMaker("비트자동차");

Car car = new Car();
car.setMaker("자바자동차");
car.setModel("씽씽이");
car.setCapacity(5);
car.setSunroof(true);
car.setEngine(engine);

request.setAttribute("car", car);
%>
<pre>
1) 보관소명 생략
\${객체이름} : pageContext.findAttribute("객체이름")

2) 보관소명을 생략하면 다음 순서로 객체를 찾는다.
PageContext => ServletRequest => HttpSession => ServletContext
자바코드:
Car car = pageContext.getAttribute("car");
if (car == null) {
  car = request.getAttribute("car");
  if (car == null) {
    car = session.getAttribute("car");
    if (car == null) {
      car = application.getAttribute("car");
    }
  }
}


3) 예
\${car.engine.cc} => ${car.engine.cc}  : requestScope 생략
</pre>

</body>
</html>







