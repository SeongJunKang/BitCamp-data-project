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
	<h1>EL 사용법 : 요청프로토콜에 있는 헤더 값 꺼내기</h1>
	<pre>
문법) 
\${header.헤더명} : request.getHeader("헤더명");
\${headerValues.헤더명} : request.getHeaders("헤더명");

예) 요청 프로토콜 

GET /web02/step04/servlet16?name=aaa&email=bbb&tel=ccc HTTP/1.1
Host: localhost:8080
Connection: keep-alive
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*\\/*;q=0.8
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.94 Safari/537.36
Referer: http://localhost:8080/web02/step04/getpost2.html
Accept-Encoding: gzip, deflate, sdch
Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4

헤더값 꺼내기)
Host = ${header.host}
Accept = ${header.accept}
User-Agent = ${header.user-Agent}
User-Agent = ${header["user-Agent"]} 
Referer = ${header.referer}

# User-Agent 헤더 값이 출력되지 않는다. 이유?
=> OGNL 표기법에서 다음 방식으로 프로퍼티 값을 꺼낼 때는
공백이나 - 등이 올 수 없다. 
\${객체명.프로퍼티명}
=> 프로퍼티명에 공백이나 "-" 등 변수 사용할 수 없는 문자가 포함된 경우,
  대괄호를 이용하여 프로퍼티 값을 꺼내라!.
\${객체명["프로퍼티명"]}   

#Referer 헤더는 무엇인가?
=> 이 페이지를 방문하기 전에 어떤 페이지에 있었는지 알려주는 정보다.
=> 웹 페이지에서 링크를 클릭하면 대부분의 웹브라우저가 이 정보를 넘긴다.
=> 이 헤더는 개발자가 넘기는 것이 아니라 웹브라우저가 넘긴다!

</pre>
</body>
</html>
