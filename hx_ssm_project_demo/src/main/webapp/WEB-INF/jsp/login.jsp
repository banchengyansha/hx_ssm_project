<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="UTF-8">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

  <h1>登陆页面</h1>

  <form action="/user/login.do" method="post">
    用户名：<input type="text" name="name"><br/>
    密码：<input type="text" name="password"><br/>
    <button type="submit">登陆</button>
  </form>


</body>
</html>
