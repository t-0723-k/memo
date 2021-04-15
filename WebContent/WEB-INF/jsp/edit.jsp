<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="model.Post" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メモ編集</title>
</head>
<body>
<h1>Hello Memo　　メモ編集画面</h1>
<form action="<%=request.getContextPath() %>/UpdateServlet" method="post">
<h3>タイトル：</h3>
<input type="text" value="編集前のタイトル">
<h3>本文：</h3>
<textarea rows="4" cols="40">編集前の本文</textarea>
<input type="submit" value="変更内容登録">
<a href="<%=request.getContextPath() %>/ListServlet">戻る</a>
</form>
</body>
</html>