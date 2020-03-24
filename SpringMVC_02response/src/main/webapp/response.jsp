<%--
  Created by IntelliJ IDEA.
  User: zachary
  Date: 2020/3/22
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script>
        //页面加载  绑定单击事件
        $(function(){
            $("#btn").click(function () {
              //发送ajax请求
                $.ajax({
                    //编写json格式，设置属性和值
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"hehe","password":"213213","age":30}',
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        //data服务器响应的json数据，进行解析
                        alert(data);
                        alert(data.username);
                        alert(data.age);
                        alert(data.password);
                    }
                });
            });
        });
    </script>
</head>
<body>
    <a href="user/testString">testString</a>
    <br>
    <a href="user/testVoid">testVoid</a>
    <br>
    <a href="user/testForwardOrRedirect">testForwardOrRedirect</a>
    <br>
<button id="btn">发送ajax请求</button>
    <br>
    <a href="user/testModelAndView">testModelAndView</a>
    <br>

</body>
</html>
