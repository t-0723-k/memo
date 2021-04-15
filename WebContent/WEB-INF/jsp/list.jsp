<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
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
List<Post> postsList = (ArrayList<Post>)request.getAttribute("postsList");
%>
<table>
	<tr>
	 	<th>MEMO_ID</th>
	 	<th>タイトル</th>
	 </tr>
	 <%--
	 <%
	 for(Post post : postsList) {
	 %>
	 <tr>
	 	<td><%= post.getId() %></td>
	 	タイトルを押下したら、ShowServletへPOST
	 	<td><form action="<%=request.getContextPath() %>/ShowServlet" method="post"><a href=''><%=post.getTitle() %></a></form></td>
	 </tr>
	 <% } %>
	 --%>
	 </table>
	 <form action="<%=request.getContextPath() %>/NewServlet" method="get">
	 <input type="submit" value="新規メモ">
	 </form>
</body>
</html>