<%--
  Created by IntelliJ IDEA.
  User: zachary
  Date: 2020/2/18
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el隐式对象</title>
</head>
<body>
    ${pageContext.request}<br>
    <h3>动态获取虚拟目录</h3>
    ${pageContext.request.contextPath}

</body>
</html>
