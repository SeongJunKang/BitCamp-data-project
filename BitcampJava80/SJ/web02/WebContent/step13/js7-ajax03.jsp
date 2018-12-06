<%@page import="com.google.gson.Gson"%>
<%@page import = "step13.Board" %>
<%@page import = "java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
ArrayList<Board> list = new ArrayList<>();
list.add(new Board(1,"제목1","홍길동",10));
list.add(new Board(2,"제목2","임꺽정",20));
list.add(new Board(3,"제목3","유관순",30));
list.add(new Board(4,"제목4","이순신",40));
list.add(new Board(5,"제목5","안중근",50));
// 모델객체에서 게시물 목록을 받았다고 가정하자.
// ArrayList에 들어있는 객체를 JSON 문자열로 자동으로 바꾸려면,
// 도우미 클래스가 필요하다.
// 누구 ?
// JSON <==>자바객체 상호변환기
%>
<%=new Gson().toJson(list) %>
