<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//{"name":"정유미","email":"example@email.com","bank":"비트은행","account":"123456789","holder":"엄진영"}
HashMap<String,Object> result = new HashMap<>();
result.put("name","정유미");
result.put("email","example@email.com");
result.put("bank","비트은행");
result.put("account","123456789");
result.put("holder","곽용호");
%>
<%= new Gson().toJson(result) %>