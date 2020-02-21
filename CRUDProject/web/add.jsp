<%@page contentType="text/html; charset=utf-8" language="java" pageEncoding="UTF-8" %>
<!-- HTML5文档-->
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
    <title>添加用户</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>

    <script type="text/javascript">
//在用户名焦点失去时   ，验证用户名是否正确
        document.form1.name.onblur=function () {
            checkName();
        }
        function check() {

            var flag=true;
            if(!checkName()) flag=false;

            if(!checkAge()) flag=false;
            if(!checkAddress()) flag=false;
            if(!checkGender())  flag=false;
            return flag;
        }
 function checkName(){
            //定义正则
            var nameReg=/^[s-zA-Z][a-zA-Z0-9]{5,9}$/g;   //  /^: 限定开头:
            //获取用户输入的值
            var name=document.form1.name.value;
            //使用正则验证是否正确
            if(nameReg.test(name)){
                removeError(document.form1.name);

                return true;//成功  return true
            }else{
                //alert("用户名必须以字母开头，长度在6——10位之间！");
                addError(document.form1.name,"用户名必须以字母开头，长度在6——10位之间！");

                return false;//失败   提示用户哪里错了    return false

            }
        }

        function  checkAge() {
            var age=document.form1.age.value;
            if(isNaN(+age)||age.length==0){
                addError(document.form1.age,"请输入有效年龄");
                return false;
            }else{
                if(age>0&&age<=120){
                    removeError(document.form1.age.value);
                    return true;
                }else{
                    addError(document.form1.age,"请输入人类有效年龄");
                    return false;
                }
            }

        }

        ////==========》添加提示信息的方法
        //参数1将错误信息添加到什么位置，参数2提示信息的内容
        function addError(where,what) {
            //添加之前先清空错误消息
            removeError(where);

            //创建font标签
            var font=document.createElement("font");
            //设置color属性为red
            font.setAttribute("color","red");
            //设置标签内容what
            font.innerHTML=what;
            //创建好放到where之后
            where.parentNode.appendChild(font);
        }
        function removeError(where) {
            var td= where.parentNode;
            var font=td.getElementsByTagName("font")[0];
            if(font){
                td.removeChild(font);
            }
        }
        function checkAddress() {
            var address = document.form1.address;
            var selectedIndex = address.selectedIndex;
            if(selectedIndex>0){
                removeError(address);
                return true;
            }else{
                addError(address,"地址未选择");
                return false;
            }

        }

        function checkGender(){
            var gender = document.getElementsByName("gender");
            if(gender.length>0){
                removeError(document.form1.gender);
                return true;
            }else{
                addError(document.form1.gender,"性别未选中");
                return false;
            }
        }

    </script>


</head>
<body>
<div class="container">
    <center><h3>添加联系人页面</h3></center>
    <form action="${pageContext.request.contextPath}/addUserServlet" name="form1" method="get" onsubmit="return check()" >
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名"><span id="s_name">

        </span>
        </div>

        <div class="form-group">
            <label>性别：</label>
            <input type="radio" name="gender" value="男" checked="checked"/>男
            <input type="radio" name="gender" value="女"/>女

        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄">
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <select name="address" class="form-control" id="address">
                <option value="广东">广东</option>
                <option value="广西">广西</option>
                <option value="湖南">湖南</option>
            </select>

        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control" id="qq" name="qq" placeholder="请输入QQ号码"/>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" class="form-control" id="email" name="email" placeholder="请输入邮箱地址"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" value="返回" />
        </div>
    </form>
</div>
</body>

</html>