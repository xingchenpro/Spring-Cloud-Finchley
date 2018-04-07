<%--
  Created by IntelliJ IDEA.
  User: hly
  Date: 2018/4/6
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%--因为WEB-INF的作用就是保护JSP不被直接访问。所有放在WEB-INF里的jsp文件只能通过转发的方式访问到。
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%String path = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<%=path%>/static/source/css/Login_Register_style.css" />
    <script src="<%=path%>/static/source/js/jquery.min.js"></script>
    <script  src="<%=path%>/static/source/js/common.js"></script>
    <!--背景图片自动更换-->
   <%-- <script  src="<%=path%>/static/source/js/supersized.3.2.7.min.js"></script>
    <script  src="<%=path%>/static/source/js/supersized-init.js"></script>--%>
    <!--表单验证-->
    <script src="<%=path%>/static/source/js/jquery.validate.min.js"></script>
</head>
<body>
<div class="register-container">
    <h1>SSM框架注册</h1>

    <div class="connect">
        <p>git地址:https://gitee.com/Sirius_hly/mavenssm</p>
    </div>

    <form action="<%=path%>/user/register" method="post"id="RegisterForm">
        <div>
            <input type="text" name="username" id="username" class="username" placeholder="您的用户名" autocomplete="off"/>
        </div>
        <div>
            <input type="password" name="password" id="password" class="password" placeholder="输入密码" oncontextmenu="return false"
                   onpaste="return false"/>
        </div>
        <div>
            <input type="password" name="confirm_password" class="confirm_password" placeholder="再次输入密码"
                   oncontextmenu="return false" onpaste="return false"/>
        </div>
        <div>
            <input type="text" name="phone_number" id="phone_number" class="phone_number" placeholder="输入手机号码" autocomplete="off"
                   id="number"/>
        </div>
        <div>
            <input type="email" name="email"id="email" class="email" placeholder="输入邮箱地址" oncontextmenu="return false"
                   onpaste="return false"/>
        </div>

        <input type="submit" id="submit" value="注册" >
    </form>

    <a href="${ctx}/user/login"><button type="button" class="register-tis">已有账号？</button></a>

</div>
<script>
    /**
     * check the login form before user login.
     * @returns {boolean}
     * val()是返回属性value对应的值。比如<input type="text" id="userName" value="123" />，使用$("#userName").val()就得到了"123"。
     */

        $(function(){
            <c:if test="${not empty param.timeout}">
            layer.msg('连接超时,请重新登陆!', {
                offset: 0,
                shift: 6
            });
            </c:if>

            if("${error}"){
                $('#submit').attr('value',"${error}").css('background','red');
            }

            if("${message}"){
                layer.msg('${message}', {
                    offset: 0,
                });
            }

            $('.close').on('click', function(c){
                $('.RegisterForm').fadeOut('slow', function(c){
                    $('.RegisterForm').remove();
                });
            });

            $('#username,#password').change(function(){
                $('#submit').attr('value','Register').css('background','#3ea751');
            });
        });

</script>
</body>
</html>
