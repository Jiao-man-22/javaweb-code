<%@page import="shoppingmall.jiao.entity.GoodsBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>货物页面</title>
</head>
<body>
<h3>货物管理</h3>
<a href="QueryGoodsAdminServlet"> 点击查询货物</a>
<table>
<%
if(request.getAttribute("listGoods")!=null){
	List<GoodsBean> listGoods=(List<GoodsBean>)request.getAttribute("listGoods");
	for(GoodsBean gb:listGoods){
%>
<tr>
<td><%=gb.getGoodsId()%></td>
<td><%=gb.getGoodsName() %></td>
<td><%=gb.getGoodsIntro() %></td>
<td><%=gb.getGoodsNum() %></td>
<td><%=gb.getGoodsPrice() %></td>
<td><%=gb.getPhoto() %></td>
<td><%=gb.getPublisher() %></td>
<td><%=gb.getClass() %></td>
<td><a href=""><button>删除</button></a></td>
<td><a href=""><button>更新</button></a></td>
</tr>

<%	}
}
%>
</table>
<a href="AdminPage.jsp">返回</a>

</body>
</html>