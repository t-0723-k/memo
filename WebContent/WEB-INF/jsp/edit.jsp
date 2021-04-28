<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="model.Post" %>
<%
Post showPost = (Post) session.getAttribute("showPost");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メモ編集</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css">
</head>
<body>
<h1>Hello Memo　　メモ編集画面</h1>

<%-- エラーメッセージ --%>

<form action="<%=request.getContextPath() %>/UpdateServlet" method="post">
	<input type="hidden" name="id" value="<%= showPost.getId() %>">
	<h3>タイトル：</h3>
	<input type="text" name="editTitle" value="<%= showPost.getTitle() %>">
	<h3>本文：</h3>
	<textarea name="editContent" rows="4" cols="40"><%= showPost.getContent() %></textarea><br>
	<input class="btn" type="submit" value="変更内容登録">
</form>
<form action="<%=request.getContextPath() %>/ListServlet" method="get">
	<input type="submit" value="戻る">
</form>
</body>
</html>