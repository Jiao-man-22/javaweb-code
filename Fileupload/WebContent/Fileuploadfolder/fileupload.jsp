<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>文件上传</title>
</head>
<body>
<form action="/Fileupload/FileUpLoadServlet"  enctype="multipart/form-data" method="post">
普通文件名: <input type="text" name="commomfile">
上传文件名:<input type="file" name="spicture">
<input type="submit" value="上传">



</form>

</body>
</html>