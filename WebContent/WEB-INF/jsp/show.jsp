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
</head>
<body>
<h1>Hello Memo　　メモ詳細画面</h1>
<h3>メモID：<%= showPost.getId() %></h3>
<h3>タイトル：<%= showPost.getTitle() %></h3>
<p>本文：<%= showPost.getContent() %></p>
<%-- 新規メモはリダイレクト、編集・削除はPOST --%>
<a href="<%=request.getContextPath() %>/NewServlet">新規メモ</a><a href="<%=request.getContextPath() %>/EditServlet">編集</a><a href="<%=request.getContextPath() %>/DeleteServlet">削除</a>
</body>
</html>

<%--
<form action="<%=request.getContextPath() %>/ShowServlet" method="post"><a href=''><%=post.getTitle() %></a></form>
 <input type="hidden" value="隠されたデータ">
--%>