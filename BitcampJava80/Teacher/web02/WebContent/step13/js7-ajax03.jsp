<%@page import="com.google.gson.Gson"%>
<%@page import="step13.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
ArrayList<Board> list = new ArrayList<>();
list.add(new Board(1, "제목11111", "홍길동", 10));
list.add(new Board(2, "제목22222", "임꺽정", 100));
list.add(new Board(3, "제목33333", "유관순", 1000));
list.add(new Board(4, "제목44444", "이순신", 10000));
list.add(new Board(5, "제목55555", "안중근", 100000));

// 모델 객체에서 게시물 목록을 받았다고 가정하자!
// ArrayList의 들어있는 객체를 JSON 문자열로 자동으로 바꾸려면,
// 도우미 클래스가 필요하다.
// 누구?
// JSON <--> 자바 객체 상호 변환기
// 
%>
<%=new Gson().toJson(list)%>











