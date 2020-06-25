<%@page import="shoppingmall.jiao.entity.GoodsBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>商品展示页</title>
 <style> 
     *{ 
        font-size: 14px;
        margin: 0;
        padding: 0;
         }
        body{
            background-image: url(image/06.jpg);
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
        border: 0;
        background-image: url(image/06.jpg);

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
        /*border: 1px black solid;*/
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
        margin:auto;
        width: 1000px;
        height: 500px;
        text-align: center;
        
     }
</style>

</head>
<body>

 <div id="header">
    <div>
    <img src="image/03.png" alt="" style="width:300px;height: 250px; background-color: white;"></div>
    <div>
     <img src="image/04.png" alt="" style="width:300px;height: 250px; background-color: white;"></div>
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
<div id="container_2">
<%
GoodsBean g=(GoodsBean)request.getAttribute("goodsbean");

%>

    <table border="1" cellspacing="0" width="1000">
        <tr>
            <td colspan="3"><p></p></td>
        </tr>
        <tr>
            <td rowspan="9" width="300"><img src="images/<%=g.getPhoto() %>" alt=""></td>
            <td colspan="2" height="20"><%=g.getGoodsName() %></td>
           
        </tr>
        <tr>
            <td colspan="2" height="20"></td>
        </tr>
        <tr>
            <td colspan="2" height="20"></td>
            
        </tr>
        <tr>
            <td colspan="2" align="left" height="20"><%=g.getGoodsPrice() %></td>
           
        </tr>
        <tr>
            <td colspan="2" height="20"></td>
            
        </tr>
        <tr>
            <td colspan="2" height="20" align="left"><%=g.getPublisher() %></td>
           
        </tr>
        <tr>
            <td colspan="2" height="20" align="left"><%=g.getGoodsNum() %></td>
            
        </tr>
        <tr>
            <td colspan="2" height="20" align="left"><%=g.getType() %></td>
  
        </tr>
        <tr><td colspan="2"align="left" valign="top"><%=g.getGoodsIntro() %></td></tr>
  
        <tr>
       <td colspan="3" height="20" align="left">
                <a href="GoodsCartOrderServlet?GoodsId=<%=g.getGoodsId()%>"><button>购买</button></a><a href="QueryAllGoodsServlet"><button>返回大厅</button></a>
            </td>
        </tr>
        <tr>
            <td colspan="3"></td>
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
</div>

</body>
</html>