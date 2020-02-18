<%@ page import="domain.User" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: zachary
  Date: 2020/2/18
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        User user=new User();
        user.setName("张三");
        user.setAge(18);
        user.setBirthday(new Date());
        request.setAttribute("u",user);

        List list=new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add(user);
        request.setAttribute("list",list);


        Map map=new HashMap();
        map.put("sname","李四");
        map.put("gender","男");
        map.put("user",user);
        request.setAttribute("map",map);
    %>
    <h3>获取对象中的值</h3>
    ${requestScope.u}<br>
<%--    通过的是对象的属性来获取
        *setter或getter方法，去掉set或get，在剩余部分，首字母变为小写。
        *setName---》Name---name--%>
    ${requestScope.u.name}<br>
    ${u.age}<br>
    ${u.birthday}<br>
    ${u.birthday.month}<br>
    ${u.birStr}
    <h3>获取List中的值</h3>
    ${list}<br>
    ${list[0]}<br>
    ${list[1]}<br>
    //角标越界后不会报错  什么都不会显示
    ${list[2].name}

    <h3>获取Map中的值</h3>
    ${map.gender}<br>
    ${map["gender"]}
    ${map.user.name}


</body>
</html>
