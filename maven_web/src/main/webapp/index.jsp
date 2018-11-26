<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/11/23
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="account/findController">查询</a>

    <form action="account/transferController" method="get">
        转出的用户名：<input type="text" name="sourceName"><br>
        转入的用户名：<input type="text" name="tragetName"><br>
        金额：<input type="text" name="money"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
