<%--
  Created by IntelliJ IDEA.
  User: zachary
  Date: 2020/3/22
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--常用的注解--%>
<a href="anno/testRequestParam?username=haha">RequestParam</a>
<br>

<form action="/param/testRequestBody" method="post">

    用户姓名：<input type="text" name="name"><br>
    用户年龄：<input type="text" name="age"><br>
    用户生日：<input type="text" name="date">

    <input type="submit" value="提交">
</form>

    <%--PathVariable注解测试--%>
    <a href="/anno/testPathVariable/10">testPathVariable</a>
    <br>



<form action="/anno/testModelAttribute" method="post">

    用户姓名：<input type="text" name="name"><br>
    用户年龄：<input type="text" name="age"><br>
    用户生日：<input type="text" name="date">

    <input type="submit" value="提交">
</form>


<%--testSessionAttributes--%>
<a href="/anno/testSessionAttributes">testSessionAttribute</a>
<br>

<%--getSessionAttributes--%>
<a href="/anno/getSessionAttributes">getSessionAttribute</a>
<br>

</body>
</html>
