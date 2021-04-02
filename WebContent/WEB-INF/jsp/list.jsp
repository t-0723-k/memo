<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メモ一覧</title>
<link rel="stylesheet" type="text/css" href="memo/css/style.css">
</head>
<body>
<h1>Hello Memo　　メモ一覧画面</h1>
<p>あ</p>
<%
List<Post> postsList = request.getAttribute("postsList");
%>
<table>
	<tr>
	 	<th>MEMO_ID</th>
	 	<th>タイトル</th>
	 </tr>
	 <%
	 for(Post postsList : post) {
	 %>
	 <tr>
	 	<td><%= post.get("id") %></td>
	 	<td><a href='show?id=<%= posts.get("id") %>'><%=post.get("title") %></a></td>
	 </tr>
	 <% } %>
	 </table>
	 <p><a href="new">新規メモ</a></p>
</body>
</html>