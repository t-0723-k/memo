<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="model.Post" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メモ新規作成</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css">
</head>
<body>
<h1>Hello Memo　　新規メモ作成画面</h1>
<%--
JavaScriptで
--%>

<form name="form1" action="<%=request.getContextPath() %>/CreateServlet" method="post">
<h3>タイトル：</h3>
<input id="createTitle" type="text" name="createTitle">
<h3>本文：</h3>
<textarea id="createContent" name="createContent" rows="4" cols="40"></textarea><br>
<input id="button1" type="submit" value="新規メモ登録">
</form>
<form action="<%=request.getContextPath() %>/ListServlet" method="get">
<input type="submit" value="戻る">
</form>
</body>
</html>

<script language="javascript" type="text/javascript">

    button1.addEventListener('click', (e) => {
        var createTitle = document.getElementById('createTitle').value;
        var createContent = document.getElementById('createContent').value;
        var button1 = document.getElementById('button1');

      // デフォルトのイベントをキャンセル
      e.preventDefault();

      if(createTitle == '' || createContent == '') {
        alert('タイトルと本文を入力してください。');
      } else {
        document.form1.submit();
      }
    });
  </script>


<%--
<div style="display:inline-flex">
<form><input type="text"><input type="submit"></form>
<form><input type="text"><input type="submit"></form>
</div>
--%>