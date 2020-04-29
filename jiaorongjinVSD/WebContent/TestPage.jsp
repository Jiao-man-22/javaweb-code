<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>这里是测试页面</title>
</head>
<body>
<form action="/jiaorongjinVSD/QueryUserByIdServletTest" method="post">
请输入您要查的id:<input name="id"><br>
<input type="submit" value="查询">
</br>${requestScope.UserBean==null?"":requestScope.UserBean}
</form>
<form action="/jiaorongjinVSD/UpdateUserServlet" method="post">
请输入您要更新的id:<input name="id"><br>
请输入您的名字:<input name="uname"><br>
请输入您的密码:<input name="upwd"><br>
请输入您的等级:<input name="ugrade"><br>
<input type="submit" value="更新">
</form>



</body>
</html>