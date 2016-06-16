<%@page import="java.util.ArrayList"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ArrayList<String> imglist = new ArrayList<>();
imglist.add("'img':'../img/detail/산책사진1.jpg'");
imglist.add("'img':'../img/detail/산책사진2.jpg'");
imglist.add("'img':'../img/detail/산책사진3.jpg'");

ArrayList<String> reviewlist = new ArrayList<>();
reviewlist.add("{'review':'박기석 : 어맛, 맡길곳이 없었는데 ~'}");
reviewlist.add("{'review':'김동래 : 맡아줘서 고맙군.'}");
reviewlist.add("{'review':'송지환 : 뭐야.'}");
reviewlist.add("{'review':'이민섭 : 고마워요'}");
reviewlist.add("{'review':'김현지 : 꺄'}");



HashMap<String,Object> result = new HashMap<>();
result.put("title","정유미");
result.put("subtitle","example@email.com");
result.put("views","비트은행");
result.put("photo","123456789");
result.put("name","");
result.put("age","");
result.put("like","");
result.put("price","");
result.put("confirm","");
result.put("trust","");
result.put("intro","");
result.put("type","");
result.put("addr","");
result.put("hospital","");
result.put("pet","");
result.put("career","");
result.put("service","");
result.put("animal","");
result.put("max","");
result.put("inqur","");
result.put("need","");
result.put("trust","");
result.put("imglist",imglist);
//,"reviewlist":[{"review":"박기석 : 어맛, 맡길곳이 없었는데 ~"},{"review":"김동래 : 맡아줘서 고맙군."},{"review":"송지환 : 뭐야."},{"review":"이민섭 : 고마워요"},{"review":"김현지 : 꺄"}]
//,"imglist":[{"img":"../img/detail/산책사진1.jpg"},{"img":"../img/detail/산책사진2.jpg"},{"img":"../img/detail/산책사진3.jpg"}]
%>
<%= new Gson().toJson(result) %>

