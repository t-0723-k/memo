<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="model.Post" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メモ新規作成</title>
</head>
<body>
<h1>Hello Memo　　新規メモ作成画面</h1>
<div style="display:inline-flex">
<form action="<%=request.getContextPath() %>/CreateServlet" method="post">
<h3>タイトル：</h3>
<input type="text">
<h3>本文：</h3>
<textarea rows="4" cols="40"></textarea><br>
<input type="submit" value="新規メモ登録">
</form>
<form action="<%=request.getContextPath() %>/ListServlet" method="get">
<input type="submit" value="戻る">
</form>
</div>
</body>
</html>

<%--
<div style="display:inline-flex">
<form><input type="text"><input type="submit"></form>
<form><input type="text"><input type="submit"></form>
</div>
--%>