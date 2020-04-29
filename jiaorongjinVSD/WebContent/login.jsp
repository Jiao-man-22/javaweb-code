<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>这里是登录页</title>
<script type="text/javascript">
function registerPage(){
	window.open("register.jsp");
}
</script>
</head>
<body>
<form action="/jiaorongjinVSD/LoginClServlet" method="post">
请输入您的名字:<input name="uname"><br>
请输入您的密码:<input name="upwd"><br>
<input type="submit" value="登陆">
<input type="button" value="注册" onclick="">
 <br>
</form>

</body>
</html>