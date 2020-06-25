<%@page import="shoppingmall.jiao.DBUtils.Paged"%>
<%@page import="shoppingmall.jiao.entity.GoodsBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>商品展示页</title>
  <meta charset="UTF-8">
    <title>Document</title>
    <style>
    *{  margin: 0;
        padding: 0;
         }
    body{
        background-image: url(image/07.jpg);
        background-repeat: no-repeat;
        background-size: cover;

    }
    
    #header{
        width: 1000px;
        height: 300px;
        border: 1px black solid;
        margin: auto;
        background-color: white;
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
        border: 0;

    }
    #header #three p a{
        color: black;
        
        text-decoration: none;

    }
    #header #nav{
        width: 1000px;
        height: 50px;
       /* border: 1px black solid;*/

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
    #container{
        width: 1000px;
        margin: auto;
        overflow: hidden;
        background-color: #cccccc;
        border: 1px greenyellow solid;
    }
    #container #inner_box{
        width: 240px;
        height: 250px;
        border: 1px green solid;
        float: left;
        margin-bottom: 10px;
        box-sizing: border-box;
    }
   #container #inner_box div{
   float: left;
   
   }
   .img{
   width:100px;
   height:200px;
   z-index:999;
   }
  .img:hover{
    transition: all 1s;
	width: 130px;
	height: 225px;
	opacity: 0.6;  
    }
    


 
   

    #buttom_div{
        width: 1000px !important;
        height:15px !important;
        margin: 0 !important;
        text-align: center;
        line-height: 15px;
        border:0 !important;

    }
    #footer{
        width: 1000px;
        height: 150px;
        margin: auto;
        border:1px yellow solid;
        background-color: #789456;
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
        text-align: center;
        width: 200px;
        height: 170px;
    }
    .ranker{
      float: right;
    
    }
</style>
<script type="text/javascript">
	window.onload=function(){
		var olist=document.getElementById("list")
		function animate(offset){
			var newleft=parseInt(olist.offsetLeft)+offset
			if(newleft<-500){
				olist.style.left=0+'px';
			}else if(newleft>0){
				olist.style.left=0+'px';
			}else{
				olist.style.left=newleft+'px';
			}	
		}
		var timer;
		function play(){
			timer=setInterval(function(){
				animate(-200);
			},1500)
		}
		play();
	}
</script>
</head>
<body>
<%



%>
<div id="header">
    <div>
    <img src="images/03.jpg" alt="" style="width:300px;height: 250px; "></div>
    <div>
     <img src="images/04.jpg" alt="" style="width:300px;height: 250px; "></div>
    
        <p><a href="MyAccountServlet">【我的账号】</a></p>
        <p><a href="LoginCartServlet">【我的购物车】</a>
         <p><a href="LogoutServlet">【注销】</a>
     	<jsp:include page="ranker.jsp"/>
  
    <div id="nav">
        <ul>
            <li><a href="">首页</a></li>
            <li><a href="">香港电影</a></li>
            <li><a href="">大陆电影</a></li>
            <li><a href="">关于我们</a></li>
        </ul></div>
</div>

<div id="container">
<% List<GoodsBean> list=(List<GoodsBean>)request.getAttribute("list");%> 
<% if(list!=null){
%>
<%for(GoodsBean g:list){
	%> 
<div id="inner_box">
<div><img class="img" src="images/<%=g.getPhoto() %>" alt=""></div>
<div>
<a href="QueryGoodsById?GoodsId=<%=g.getGoodsId()%>"><%=g.getGoodsId() %>--购买</a>
<%=g.getGoodsName() %><br>
</div>

<div style="margin-top:200px;margin-left:-160px">影片总结：<%=g.getGoodsIntro()%></div>

</div>
<%} 
}else{
	System.out.println("list="+list);
}%>
<% int totall=(int)request.getAttribute("totallPages"); 
%>
</div>
<div id="buttom_div">
        <%
        for(int i=0;i<totall;i++){
        	%>
        	<a href="PagedServlet?i=<%=i+1%>">【<%=i %>】</a>
        <% }
        %>
    </div>
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