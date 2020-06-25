<%@page import="java.net.URLEncoder"%>
<%@page import="shoppingmall.jiao.entity.GoodsBean"%>
<%@page import="shoppingmall.jiao.entity.UserBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>这里是管理员页面</title>
 
</head>
<body>
<div>
<form action="QueryUsersServlet" method="post">
<input name="UserBeanName" type="text">
<input type="submit" value="提交">
</form>
</div>
<h2>================登陆管理员界面===============</h2>
<table border="1">
<tr>
<td>id</td>
<td>用户名</td>
<td>密码</td>
<td>等级</td>
<td>邮件</td>
<td>手机号</td>
<td>邮政</td>
<td>类型</td>
<td>删除</td>
<td>更新</td>
</tr>
<% if(request.getAttribute("userlist")!=null &&  request.getAttribute("totallPages")!=null){%>
<% 
List<UserBean> list=(List<UserBean>)request.getAttribute("userlist");
for(UserBean ub:list){
%>
<tr>
<td><%=ub.getUserid() %></td>
<td><%=ub.getUsername() %></td>
<td><%=ub.getPasswd() %></td>
<td><%=ub.getGrade() %></td>
<td><%=ub.getEmail() %></td>
<td><%=ub.getPhone() %></td>
<td><%=ub.getPostcode() %></td>
<td><%=ub.getClass() %></td>
<td><a href="QueryUsersServlet?UserBeanName=<%=URLEncoder.encode(ub.getUsername(), "utf-8")%>&event=del"><button>删除</button></a></td>
<td><a href=""><button>更新</button></a></td>
</tr>
<%
}
%>
<%
int pages=(int)request.getAttribute("totallPages");
for(int i=0;i<pages;i++){
	
%>
<a href="QueryUsersServlet?i=<%=i+1 %>">【<%=i %>】</a>
<%} 

%>

<%
}
if(request.getAttribute("userbean")!=null){
	UserBean ub=(UserBean)request.getAttribute("userbean");
	
%>
<tr>
<td><%=ub.getUserid() %></td>
<td><%=ub.getUsername() %></td>
<td><%=ub.getPasswd() %></td>
<td><%=ub.getGrade() %></td>
<td><%=ub.getEmail() %></td>
<td><%=ub.getPhone() %></td>
<td><%=ub.getPostcode() %></td>
<td><%=ub.getClass() %></td>
<td><a href="QueryUsersServlet"><button>删除</button></a></td>
<td><a href=""><button>更新</button></a></td>
</tr>
<%	
}
%>	
</table>
<h3>货物管理</h3>
<a href="QueryGoodsAdminServlet"> 点击查询货物</a>
<table>
<%
if(request.getAttribute("listGoods")!=null){
List<GoodsBean> listGoods=(List<GoodsBean>)request.getAttribute("listGoods");
for(GoodsBean gb :listGoods){
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
<%
}
}
%>
</table>







</body>
</html>