<%--
  Created by IntelliJ IDEA.
  User: zachary
  Date: 2020/2/18
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取域中的数据</title>
</head>
<body>
    <%
        //在域中存储数据
        request.setAttribute("name","张三");
        session.setAttribute("age",18);
    %>
    <h3>el获取值</h3>
    ${requestScope.name}
    ${sessionScope.age}
    ${sessionScope.haha}//没有的话什么都不会显示
</body>
</html>
