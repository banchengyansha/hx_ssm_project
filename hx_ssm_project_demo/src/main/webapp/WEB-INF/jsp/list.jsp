<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="UTF-8">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

  <h1>学生信息列表</h1>
  <table border="1" cellspacing="0">
    <tr>
      <th>学生id</th>
      <th>学生名称</th>
      <th>学生性别</th>
      <th>学生年龄</th>
      <th>居住地址</th>
    </tr>

    <c:forEach items="${stulist}" var="s">
      <tr>
        <td>${s.id}</td>
        <td>${s.name}</td>
        <td>${s.sex}</td>
        <td>${s.age}</td>
        <td>${s.address}</td>
      </tr>
    </c:forEach>

  </table>

</body>
</html>
