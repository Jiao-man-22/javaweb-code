<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登陆页面</title>
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
        border:1px black solid;
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
     #container_3 div{
     	border: 1px black solid;
     	width: 1000px;
     	height: 200px;
     	margin: auto;
     }
     table{
     	margin: auto;
     }
     </style>
</head>
<body>
	<div id="header">
    <div>
    <img src="image/03.png" alt="" style="width:300px;height: 250px;"></div>
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
<div id="container_3">
<div style="width: 1000px;height: 100px;"></div>
<div style="width: 1000px;height: 200px;padding-top: 50px;">
<form action="LoginClServlet" method="post">
<table border="1" cellspacing="0" cellpadding="" width="400" height="100">
		<tr><td colspan="2" align="center" height="50"><h1>请登录</h1></td></tr>
		<tr><td width="300"  align="right">用户：</td><td width="300" ><input type="text" name="uname" id="" value="" style="width: 150px" /></td></tr>
		<tr><td width="300"  align="right">密码：</td><td width="300" ><input type="password" name="upwd" id="" value=""  style="width: 150px" /></td></tr>
		<tr><td align="right"><input type="submit" value="用户登陆"></td><td><a href=""><button>用户注册</button></a></td></tr>
	</table>
</form>
	
</div>
<div style="width: 1000px;height: 100px;"></div>	
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