<%@page import="shoppingmall.jiao.entity.GoodsBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>商品详情页</title>
</head>
<body>
<%
GoodsBean g=(GoodsBean)request.getAttribute("goodsbean");
System.out.println(g);
%>
<%=g.getGoodsId() %>
<%=g.getGoodsName() %>
<%=g.getGoodsIntro() %>
<%=g.getGoodsPrice() %>
<%=g.getGoodsNum() %>
<%=g.getPublisher() %>
<%=g.getPhoto() %>






</body>
</html>