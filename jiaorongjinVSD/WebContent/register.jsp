<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>这里是注册页面</title>
<script type="text/javascript" src="./js/jquery.js"></script>
<script type="text/javascript">
	  //function check(){
	  //var name=$("#name").val();
		//var pwd=$("#pwd").val();		
	    //var grade=$("#grade").val();
		//if(!(name.length>=2 & name.length<=4)){
		//	alert("名字必须在2-4之间");
			//return false;
		}
		//if(){};
		//if(){};
		//if(){};
			//return true;
	
		</script>
</head>
<body>
<form action="/jiaorongjinVSD/AddUserServlet" method="post" onsubmit="return check()">
请输入您的名字:<input id="name" name="uname"><br>
请输入您的密码:<input id="pwd" name="upwd"><br>
请输入您的等级:<input id="grade" name="ugrade"><br>
<input type="submit" value="注册">
</form>
<a href="/jiaorongjinVSD/welcome.jsp"><button>返回</button></a>

<h2>ajax异步刷新</h2>
查询用户：<input id="checkUser"><br>
<input type="button" onclick="checkUser()" value="查询">
</body>
</html>