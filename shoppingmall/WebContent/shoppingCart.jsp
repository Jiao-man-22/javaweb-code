<%@page import="java.util.List"%>
<%@page import="shoppingmall.jiao.entity.GoodsBean"%>
<%@page import="shoppingmall.jiao.DBUtils.ShoppingCart"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>购物车</title>
		<style>
			* {
				margin: 0;
				padding: 0;
			}
			
			#header {
				width: 1000px;
				height: 300px;
				border: 1px black solid;
				margin: auto;
			}
			
			#header div {
				width: 300px;
				height: 250px;
				float: left;
				border: 1px black solid;
			}
			
			#header #three {
				width: 400;
				line-height: 50px;
				border: 0;
			}
			
			#header #three p a {
				color: black;
				text-decoration: none;
			}
			
			#header #nav {
				width: 1000px;
				height: 50px;
			}
			
			#header #nav li {
				list-style: none;
				float: left;
				border: 1px black solid;
				width: 100px;
				height: 50px;
				margin-left: 100px;
				box-sizing: border-box;
			}
			
			#header #nav li {
				line-height: 50px;
				background-color: green;
				text-align: center;
			}
			
			#header #nav li a {
				text-decoration: none;
			}
			
			#footer {
				width: 1000px;
				height: 150px;
				margin: auto;
				border: 1px yellow solid;
			}
			
			#footer #footer_top {
				width: 800px;
				margin: auto;
				background-color: yellow;
				text-align: center;
			}
			
			#footer #footer_buttom {
				width: 800px;
				margin: auto;
			}
			
			#footer #footer_buttom span {
				width: 800px;
				margin: auto;
				display: block;
				text-align: center;
			}
			
			table {
				width: 1000px;
			
				margin: auto;
				border: 1px;
			}
			.first_table{
				width: 1000px;
				height: 100px;
				margin: auto;
				border: 1px;
				cellspacing:0;
			}
			
			.second_table{
				width: 1000px;
				height: 50px;
				margin: auto;
				border: 1px;
				line-height:50px;
				
			}
			
			.small_box {
				display: inline-block;
				width: 50px;
				height: 20px;
				border: 1px black solid;
			}
		</style>
</head>
<body>
<div id="header">
			<div>
				<img src="image/03.png" alt="" style="width:300px;height: 250px; "></div>
			<div>
				<img src="image/04.png" alt="" style="width:300px;height: 250px; "></div>
			<div id="three">
				<p>
					<a href="MyAccountServlet">【我的账号】</a>
				</p>
				<p>
					<a href="LoginCartServlet">【我的购物车】</a>
			</div>
			<div id="nav">
				<ul>
					<li>
						<a href="">首页</a>
					</li>
					<li>
						<a href="">香港电影</a>
					</li>
					<li>
						<a href="">大陆电影</a>
					</li>
					<li>
						<a href="">关于我们</a>
					</li>
				</ul>
			</div>
		</div>
		
		<table class="first_table" border="1" cellspacing="0" cellpadding="1">
			<tr align="center" height="20">
				<td colspan="6" style="background-image: url(image/08.jpg); background-size: contain;"></td>
			</tr>
			<tr align="center"  height="20">
				<td>编号</td>
				<td width="300">名称</td>
				<td width="150">单价</td>
				<td align="center">数量</td>
			</tr>
			</table>
			<%  List<GoodsBean> list=(List<GoodsBean>)request.getAttribute("list");
			if(list!=null){
			for(GoodsBean g:list){
				
			%>
			<form action="ShoppingCartPageOrder" method="post">
			<table class="second_table" border="1" cellspacing="0" cellpadding="1" >
			<tr align="center" width="1000" height="20">
				<td width="271"><%=g.getGoodsId() %></td>
				<td width="300"><%=g.getGoodsName() %></td>
				<td width="150"><%=g.getGoodsPrice() %></td>
				<td>
				<input name="goodsNum" value="<%=g.getGoodsNum() %>">
				<input name="goodsId" type="hidden" value="<%=g.getGoodsId() %>">
				<input name="goodsName" type="hidden" value="<%=g.getGoodsName()%>">
				<input name="goodsPrice" type="hidden" value="<%=g.getGoodsPrice()%>">
				</td>
				<td>
					<input type="submit" value="修改">
				</td>
				<td>
					<a href="DeleteCartGoodsServlet?GoodsId=<%=g.getGoodsId() %>">删除</a>
				</td>
			</tr>
			</table>
			</form>
			
			<%
			}
			} %>
			<table>
			<tr align="center" width="1000" height="20">
				<td colspan="3"> <a href="ClearCartServlet">删除全部商品</a></td>
				<td colspan="3"> <a href="ShoppingCartPageOrder">修改全部商品</a></td>
			</tr>
			<tr align="center" width="1000" height="20">
				<td colspan="6"></td>
			 </tr>
					<tr align="center" width="1000" height="20">
						<td colspan="6"></td>

					</tr>
					<tr align="center" width="1000" height="20">
						<td colspan="3">
						<%
					
						
						
						%>
							<p>您的商品总计￥<%=request.getAttribute("totalPrice") %></p>
						</td>
						<td colspan="3">
							<a href="QueryAllGoodsServlet">点击返回</a>
						</td>

					</tr>
		</table>

		<div id="footer">
			<div id="footer_top">合作伙伴：无锡工艺，搜狐，新浪</div>
			<div id="footer_buttom">
				<span>地址：无锡职业技术学院</span>
				<span>制作人：jrj</span>
				<span>时尚购物网</span>

			</div>
		</div>


</body>
</html>