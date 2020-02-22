<%@page contentType="text/html;charset=utf-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <div style="float: left">
        <form class="form-inline" action="${pageContext.request.contextPath}/findByPageServlet">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" class="form-control" name="name" value="${map.name[0]}" id="exampleInputName2" placeholder="Jane Doe">
            </div>
            <div class="form-group">
                <label for="exampleInputaddress2">籍贯</label>
                <input type="email" class="form-control" name="address" value="${map.address[0]}" id="exampleInputaddress2" placeholder="jane.doe@example.com">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail2">邮箱</label>
                <input type="email" class="form-control" name="email" value="${map.email[0]}" id="exampleInputEmail2" placeholder="jane.doe@example.com">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>
    <div style="float: right">
        <a class="btn btn-primary" href="add.jsp">添加联系人</a>
        <a class="btn btn-primary" id="deleteSelected" href="javascript:void(0);">删除选中</a>
    </div>
    <form id="form" action="${pageContext.request.contextPath}/deleteSelectedServlet" method="post">
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th><input type="checkbox" id="selectall"></th>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${pb.list}" var="user" varStatus="s">
            <tr>
                <td><input type="checkbox" name="selected" value="${user.id}"></td>
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.gender}</td>
                <td>${user.age}</td>
                <td>${user.address}</td>
                <td>${user.qq}</td>
                <td>${user.email}</td>
                <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findUserServlet?id=${user.id}">修改</a>&nbsp;<a class="btn btn-default btn-sm" href="javascript:deleteUser(${user.id})">删除</a></td>
            </tr>
        </c:forEach>
    </table></form>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
               <%-- 设置分页条下限限制--%>
                <c:if test="${pb.currentPage==1}">
                    <li class="disabled">
                </c:if>
               <c:if test="${pb.currentPage!=1}">
                   <li>
               </c:if>
                    <a href="${pageContext.request.contextPath}/findByPageServlet?currentPage=${pb.currentPage-1}&rows=5&name=${map.name[0]}&address=${map.address[0]}&email=${map.email[0]}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
<%--
                设置分页条是否为激活状态--%>
                <c:forEach begin="1" end="${pb.totalPage}" var="i">
                    <c:if test="${pb.currentPage==i}">
                        <li class="active">   </c:if>
                    <c:if test="${pb.currentPage!=i}">
                        <li>   </c:if>
                    <a href="${pageContext.request.contextPath}/findByPageServlet?currentPage=${i}&rows=5&name=${map.name[0]}&address=${map.address[0]}&email=${map.email[0]}">${i}</a></li>

                </c:forEach>
                   <%-- 设置分页条上限限制--%>
                    <c:if test="${pb.currentPage==pb.totalPage}">
                    <li class="disabled">
                        </c:if>
                        <c:if test="${pb.currentPage!=pb.totalPage}">
                    <li>
                        </c:if>
                    <a href="${pageContext.request.contextPath}/findByPageServlet?currentPage=${pb.currentPage+1}&rows=5&totalPage=${pb.totalPage}&name=${map.name[0]}&address=${map.address[0]}&email=${map.email[0]}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size: 25px;margin-left: 5px">
          共${pb.totalCount}条记录，共${pb.totalPage}页
        </span>
            </ul>
        </nav>

    </div>





</div>
</body>
<script type="text/javascript">
    function deleteUser(id) {
        if(confirm("您确定要删除用户信息吗？")){
            location.href="${pageContext.request.contextPath}/deleteUserServlet?id="+id;
        }

    }

        //给删除选中按钮绑定单击事件
           document.getElementById("deleteSelected").onclick=function () {

                if(confirm("是否删除选中？")){
                    //判断是否有选中  排除空指针异常
                    var flag=false;
                    var elements = document.getElementsByName("selected");
                    for(var i=0;i<elements.length;i++){
                        if(elements[i].checked){
                            flag=true;
                        }
                    }
                  if(flag){
                      //表单提交
                      var form = document.getElementById("form");
                      form.submit();
                  }
                }

       }
       document.getElementById("selectall").onclick=function(){
                  //获取表中的所有复选框
                var cbs = document.getElementsByName("selected");
                for(var i=0;i<cbs.length;i++){
                    //设置这些复选框的checked状态和全选框保持一致
                    cbs[i].checked=this.checked;
                }


       }
</script>
</html>


