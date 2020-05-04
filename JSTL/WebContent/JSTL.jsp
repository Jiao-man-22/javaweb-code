<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>JSTL的使用</title>
</head>
<body>
  el表达式  直接显示文本消息要带"" :  ${这是一个文本消息 }<br>
  el表达式  直接显示文本消息要带"" :  ${"这是一个文本消息 带引号才会显示 "} <br>
  ${"取出servlet中参数" }<br>
  ${requestScope.StringVar}<br>
  ${"取出对象"}<br>
  ${requestScope.stringarray[0]}<br>
  ${requestScope.stringarray[1]}<br>
  ${requestScope.stringarray[2]}<br>
  ${requestScope.stringarray}<br>
  ${requestScope.intattribute}<br>
  ${"JSTL语法需要引入c标签库" }<br>
  <c:set var="name" value="jiao" scope="request"/>
  ${"name=" }${requestScope.name }<br>
  <c:if test="${10>5 }" var="result" scope="request">
  	真
  	${requestScope.result }
  </c:if>
  <c:set var="job" value="混子"  scope="request"/>
  <c:choose>
  <c:when test="${requestScope.job=='混子'}">你就是一个混子 </c:when>
  <c:when test="${requestScope.job=='sb'}"> 你是一个sb</c:when>
  <c:otherwise>i什么都不是</c:otherwise>
  </c:choose>
 	遍历
  <c:forEach begin="0" end="5" step="1" varStatus="status" >
  ${status.index}====test
  </c:forEach>
  <br>
  <c:forEach var="intarray" items="${requestScope.listint}">
   ${intarray }
  </c:forEach>
  <a href="MyServlet">点击跳转</a>
    
</body>
</html>