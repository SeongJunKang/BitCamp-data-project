<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% response.setHeader("Access-Control-Allow-Origin", "*"); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>강성준</h1>
<c:choose>
	<c:when test="${param.menu == 1}">
		<h2>교육 과목</h2>
		<ol>
			<li>자바 프로그래밍
			<li>윈도우 프로그래밍
			<li>모바일 프로그래밍
		</ol>
	</c:when>
  <c:when test="${param.menu == 2}">
    <h2>강사</h2>
    <ol>
      <li>홍길동
      <li>임꺽정
      <li>유관순
    </ol>
  </c:when>
  <c:when test="${param.menu == 3}">
    <h2>매니저</h2>
    <ol>
      <li>나홀로
      <li>우리가
      <li>오호라
    </ol>
  </c:when>
  <c:otherwise>
  메뉴를 지정하세요
  </c:otherwise>
</c:choose>