<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<%--下载
不需要依赖插件
a 请求地址
b servlet通过请求地址 将文件以输入流  读到servlet
c servlet输出流的形式 将文件输出到客户端 
d 下载文件需要设置响应头
response.addHeader("content-Type","application/octet-stream") //MIME类型为二进制文件
response.addHeader("content-Disposition","attachement-filename="+FileName) 
--%>
</head>
<body>
<%--javaweb 查找可以从跟路径出发 --%>
<a href="/Fileupload/DownloadServlet?filename=01.png">点击下载</a>

</body>
</html>