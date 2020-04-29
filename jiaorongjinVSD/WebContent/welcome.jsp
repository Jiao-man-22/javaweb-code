<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>这是welcome页面</title>
<script type="text/javascript" src="./js/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("tr:odd").css("background-color","lightgray");
	});
</script>
</head>
<body>
<h2>恭喜你已登录welcome页面</h2>
<h3>======查询所有的数据===========</h3>
<a href="/jiaorongjinVSD/QueryAllUserServlet"><button>查询所有用户</button></a>
	<!--<%=request.getSession().getAttribute("allUser") %>  -->

<table border="1" cellspacing="1" cellpadding="1">
<tr><td>学号</td><td>名字</td><td>密码</td><td>等级</td><td>操作</td></tr>
<c:forEach var="item" items="${requestScope.list}">
<tr>
<td><a href="/jiaorongjinVSD/QueryUserByIdServletTest?id=${item.getId()}">${item.getId()}</a></td>   
<td>${item.getName()}</td>
<td>${item.getPwd() }</td>
<td>${item.getGrade()}</td>
<td><a href="/jiaorongjinVSD/DeleteUserServlet?id=${item.getId()}"><button value="删除">删除</button></a></td>
 </tr>
</c:forEach>
</table>
<a href="/jiaorongjinVSD/register.jsp"><button>添加用户</button></a>
</body>
</html>