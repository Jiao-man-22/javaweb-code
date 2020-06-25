<%@page import="shoppingmall.jiao.entity.GoodsBean"%>
<%@page import="shoppingmall.jiao.DBUtils.ShoppingCart"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>订单页面</title>
<style>
    *{  margin: 0;
        padding: 0;
         }
      body{
        background-image: url(image/09.jpg);
        background-repeat: no-repeat;
        background-size: 100%;
    }
    
    #header{
        width: 1000px;
        height: 300px;
        border: 1px black solid;
        margin: auto;
    }
    #header div{
        width: 300px;
        height: 250px;
        float: left;
        border: 1px black solid;

    }
    #header #three{
        width: 400;
        line-height: 50px;
        border:0;
    }
    #header #three p a{
        color: black;
        
        text-decoration: none;

    }
    #header #nav{
        width: 1000px;
        height: 50px;

    }
    #header #nav li{
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
    #header #nav li a{
         text-decoration: none;
     }
         #footer{
        width: 1000px;
        height: 150px;
        margin: auto;
        border:1px yellow solid;
    }
    #footer #footer_top{
        width: 800px;
        margin: auto;
        background-color: yellow;
        text-align: center;
    }
    #footer #footer_buttom{
        width: 800px;
        margin: auto;
    }
     #footer #footer_buttom span{
        width: 800px;
        margin: auto;
        display: block;
        text-align: center;
     }
     table{
        width: 1000px;
        height: 200px;
        margin: auto;
        border:1px;
     }
     .small_box{
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
    <div style="background-color: white;">
     <img src="image/04.png" alt="" style="width:300px;height: 250px; "></div>
    <div id="three">
        <p><a href="MyAccountServlet">【我的账号】</a></p>
        <p><a href="LoginCartServlet">【我的购物车】</a>
    </div>
    <div id="nav">
        <ul>
            <li><a href="">首页</a></li>
            <li><a href="">香港电影</a></li>
            <li><a href="">大陆电影</a></li>
            <li><a href="">关于我们</a></li>
        </ul></div>
</div>
<table border="1">
	<tr align="center">
      	<td colspan="9" rowspan="1" width="1000" height="80"></td>
      </tr>
     <tr>
      <td colspan="9" height="20" align="center">订单详情</td>
   	</tr>
  <tr height="20" align="center">
  	<td>订单号</td>
  	<td>收货人</td>
  	<td>收货地址</td>
  	<td>邮编</td>
  	<td>电话</td>
  	<td>总价</td>
  	<td>用户名</td>
  	<td>电子邮件</td>
  	<td></td>
  </tr>
  <%
		GoodsBean g=(GoodsBean)request.getAttribute("GoodsBean");
  		request.getSession().setAttribute("GoodsBean",g);
		%>
		<% if(g!=null){ %>
  
  <tr height="20" align="center">
  	<td><%=g.getGoodsId() %></td>
  	<td><%=g.getGoodsName() %></td>
  	<td><%=g.getGoodsIntro() %></td>
  	<td><%=g.getGoodsNum() %></td>
  	<td><%=g.getPublisher() %></td>
  	<td><%=g.getType() %></td>
  	<td><%=g.getGoodsPrice() %></td>
  	<td><a href="/shoppingmall/CartDetailClServlet">点击加入</a></td>
  </tr>
  
  <%}else{
	  System.out.println("GoodsBean_order"+g);
  } %>
  <tr align="right"><td colspan="9" height="30"><a href="QueryAllGoodsServlet">返回继续购买</a></td></tr>
       	



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