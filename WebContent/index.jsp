<%@page import="service.PostsService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="dao.PostsDAO" %>
<%@ page import="model.Post" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メモ一覧</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css">

</head>
<body>
<h1>Hello Memo　　メモ一覧画面</h1>
<%
PostsService ps = new PostsService();
List<Post> lp = ps.allPost();
%>
<table>
	<tr>
	 	<th>MEMO_ID</th>
	 	<th>タイトル</th>
	 </tr>
	 <%
	 int i = 1;
	 for(Post p : lp) {
	 %>
	 <tr>
	 	<td><%= i %></td>

	 	<%-- タイトルを押下したら、ShowServletへPOST--%>
	 	<td>
	 		<form action="<%=request.getContextPath() %>/ShowServlet" method="post" name="form_<%= i %>" id="form_<%= i %>" >
	 		<input type="hidden" name="id" value="<%= p.getId() %>">
	 		<a href="javascript:form_<%= i %>.submit()"><%=p.getTitle() %></a>
	 		</form>
	 	</td>
	 </tr>
	 <%
	 i ++;
	 } %>
	 </table>
	 <form action="<%=request.getContextPath() %>/NewServlet" method="get">
	 <input class="btn" type="submit" value="新規メモ">
	 </form>
</body>
</html>