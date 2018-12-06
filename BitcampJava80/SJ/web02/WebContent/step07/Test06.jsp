<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" buffer="8kb" autoFlush="true"
	trimDirectiveWhitespaces="true" import="java.util.List,java.io.File"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>지시문(directive element)</h1>
	<ul>
		<li>JSP 페이지에 대한 특별한 설정을 하고싶을 때 사용.
		<li>종류) page, include, taglib
		<li>page => 출력내용에 대한 설정.
		<li>include => JSP 페이지 안에 다른 파일의 내용을 삽입할 때 사용.
		<li>taglib => JSP 외부 태그를 선언할 때. 예: JSTL, 사용자 정의 태그
	</ul>
	<h2>page 지시어의 주요 속성</h2>
	<ul>
		<li>language : 스크립트릿 태그 안에 넣을 코드의 언어를 지정한다. 
		현재 Java만 가능. 이 속성을	생략해도 된다.
		<li>contentType : response.setContentType() 메서드를 추가한다.
		<li>pageEncoding : JSP 파일을 작성할 때 사용한 언어를 지정한다.
		 만약 이 속성을 생략한다면,	contentType에서 지정한 문자집합과 같은것으로 간주한다
		<li>autoFlush : true => 버퍼가 꽉 차면 자동으로 데이터를 클라이언트로 보낸다. 
		false => 버퍼가 꽉 차면 오류를 발생시킨다.
		<li>buffer : 버퍼 크기를 지정. 기본은 8kB이다.
		<li>errorPage : 실행 중 오류 발생했을 때 포워딩할 URL 지정.
		<li>trimDirectiveWhitespaces:지시문 태그 뒤에 붙은 공백(스페이스,탭,줄바꿈) 제거한다.
			기본은 false
		<li>import: 자바 import문을 추가한다. 콤마(,)를 사용하여 여러개를 지정할 수 있다.
		    import 속성을 여러 개 둘 수 있다.
		    import 속성만 있는 page 지시문을 만들어서 사용해도 된다.
	</ul>
</body>
</html>
