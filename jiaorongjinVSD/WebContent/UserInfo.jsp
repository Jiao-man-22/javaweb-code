<%@page import="jiaorongjinVSD.entity.User"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>用户详情页</title>
</head>
<body>
<h2>============个人详情页====================</h2>
<form action="/jiaorongjinVSD/UpdateUserServlet" methods="post">
学号 :<input name="id" readonly="readonly" value="${requestScope.user.id}"><br/>
名字:<input name="uname" value="${requestScope.user.name}"><br/>
密码:<input name="upwd"  value="${requestScope.user.pwd}"><br/>
等级:<input name="ugrade" value="${requestScope.user.grade}"><br/>
<input type="submit" value="修改">
</form>
<a href="/jiaorongjinVSD/QueryAllUserServlet"><button>返回</button></a>


</body>
</html>