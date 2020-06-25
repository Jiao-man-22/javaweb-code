<%@page import="shoppingmall.jiao.entity.RankerBean"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>热门榜单</title>
    </head>
    <body>
    <table border="1">
    <tr>
    <td>id</td>
    <td>名字</td>    
    <td>点击量</td>
    <td>详情</td>
    <td>点击加一</td>
    </tr>
      <%
    if(request.getAttribute("rankerlist")!=null){
    	List<RankerBean> list=(List<RankerBean>)request.getAttribute("rankerlist");
    	for(RankerBean rb:list){
    %>
    <tr>
    <td><%=rb.getId() %></td>
    <td><%=rb.getName() %></td>
    <td><%=rb.getClick() %></td>
    <td><a><button>详情</button></a></td>
    <td><a href="PagedServlet?rankerId=<%=rb.getId() %>&click=<%=rb.getClick() %>">加一</a></td>
    </tr>
    <%
    	}
    }
    %>
    
   
    
    </table>
    
 	</body>
</html>