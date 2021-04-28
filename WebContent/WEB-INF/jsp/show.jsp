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
<title>メモ詳細</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css">
</head>
<body>
<h1>Hello Memo　　メモ詳細画面</h1>
<%-- <h3>メモID：<%= showPost.getId() %></h3>--%>
<h3>タイトル：<%= showPost.getTitle() %></h3>
<p>本文：<%= showPost.getContent() %></p>

<%-- 新規メモはリダイレクト、編集・削除はPOST --%>
<div style="display:inline-flex">
	<form action="<%=request.getContextPath() %>/ListServlet" method="get">
		<input class="btn" type="submit" value="戻る">
	</form>
	<form action="<%=request.getContextPath() %>/EditServlet" method="get">
<%-- 	<input type="hidden" name="id" value="<%= showPost.getId() %>">  --%>
		<input class="btn" type="submit" value="編集">
	</form>
	<form action="<%=request.getContextPath() %>/DeleteServlet" method="post">
		<input type="hidden" name="id" value="<%= showPost.getId() %>">
		<input class="btn" type="submit" value="削除">
	</form>
</div>
</body>
</html>

<%--
<form action="<%=request.getContextPath() %>/ShowServlet" method="post"><a href=''><%=post.getTitle() %></a></form>
 <input type="hidden" value="隠されたデータ">
--%>