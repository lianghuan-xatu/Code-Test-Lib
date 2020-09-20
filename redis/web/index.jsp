<%--
  Created by IntelliJ IDEA.
  User: zachary
  Date: 2020/3/3
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script>
      $(function () {
          //页面加载完成  发送Ajax请求   加载所有省份数据
        $.get("/Test4/findProvinceServlet",{},function (data) {
          alert(data);
            //获取select
          var province = $("#province");
          //遍历json数组
          $(data).each(function () {
              var option="<option name='"+this.id+"'>"+this.name+"</option>";
              province.append(option);
          });

        });
      });
    </script>
  </head>
  <body>
  $END$
  <select id="province">
    <option>-----请选择省份------</option>

  </select>
  </body>
</html>
