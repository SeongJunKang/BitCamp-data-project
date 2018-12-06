<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    autoFlush="true"
    buffer="8kb"
    trimDirectiveWhitespaces="true"
    import="java.util.List,java.io.File"
    import="java.io.Reader"%>
<%@ page import="java.net.Socket" %>    
<%@ page import="java.net.ServerSocket" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<h1>지시문(directive element)</h1>
<ul>
  <li>JSP 페이지에 대한 특별한 설정을 할 때 사용.
  <li>종류: page, include, taglib
  <li>page => 출력 내용에 대한 설정.
  <li>include => JSP 페이지 안에 다른 파일의 내용을 삽입할 때 사용.
  <li>taglib => JSP 외부 태그를 선언할 때. 예: JSTL, 사용자 정의 태그
</ul>

<h2>page 지시어의 주요 속성</h2>
<ul>
  <li>language => 스크립트릿 태그 안에 넣을 코드의 언어를 지정한다. 현재 java 만 가능하다.
      이 속성을 생략해도 된다.
  <li>contentType => response.setContentType() 메서드를 추가한다.
  <li>pageEncoding => JSP 파일을 작성할 때 사용한 언어를 지정한다.
      만약 이 속성을 생략한다면 contentType에서 지정한 문자집합과 같은 것으로 간주한다.
  <li>autoFlush => true(기본), 버퍼가 꽉 찰 때 자동으로 데이터를 클라이언트로 보낸다.
      false, 버퍼가 꽉 차면 오류를 발생시킨다.
  <li>buffer => 버퍼 크기를 지정. 기본은 8KB이다.
  <li>errorPage => 실행 중 오류 발생했을 때 포워딩할 URL을 지정한다.
      지정하지 않는다면, 오류가 발생했을 때 서블릿 컨테이너의 기본 오류 페이지를 출력한다.
  <li>trimDirectiveWhitespaces => 지시문 태그 뒤에 붙은 공백(스페이스,탭,줄 바꿈)을 제거한다.
      기본은 false이다.   
  <li>import => 자바 import 문을 추가한다. 콤마(,)를 사용하여 여러 개를 지정할 수 있다.
      import 속성을 여러 개 둘 수 있다. 
      import 속성만 있는 page 지시문을 선언해도 된다. 
</ul>
</body>
</html>










