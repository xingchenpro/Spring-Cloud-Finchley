<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%String path = request.getContextPath();%>
<!doctype html>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" href="<%=path%>/static/source/css/Login_Register_style.css" />
    <script src="<%=path%>/static/source/js/jquery-2.1.4.min.js"></script>
    <script  src="<%=path%>/static/source/js/common.js"></script>
    <%--<script  src="/static/source/js/layer.js"></script>--%>

    <!--背景图片自动更换-->
    <%--<script  src="../../static/source/js/supersized.3.2.7.min.js"></script>
    <script  src="../../static/source/js/supersized-init.js"></script>--%>
    <!--表单验证-->
   <script src="<%=path%>/static/source/js/jquery.validate.min.js"></script>
</head>
<body>

<div class="login-container">
    <h1>SSM框架登录</h1>

    <div class="connect">
        <p>git地址:https://gitee.com/Sirius_hly/mavenssm</p>
    </div>

    <form action="<%=path%>/user/login" method="post" id="loginForm" >
        <!--autocomplete：其含义代表是否让浏览器自动记录之前输入的值
        http://www.w3school.com.cn/html5/att_form_autocomplete.asp-->
        <div>
        </div>
        <!--onpaste:粘贴文本操作
        oncontextmenu：点击鼠标右键操作-->
        <div>
            <input type="text" name="username" id="username" class="username" placeholder="用户名" autocomplete="off"/>
            <input type="password" name="password" id="password" class="password" placeholder="密码" oncontextmenu="return false" onpaste="return false" />
        </div>

       <%-- <button id="submit" type="submit">登 陆</button>--%>
        <input type="submit" id="submit" value="Login" >
    </form>
    <%--${ctx}获取当前根目录--%>
    <a href="${ctx}/user/register"><button type="button" class="register-tis">还有没有账号？</button></a>
   <%-- <a href="register.jsp">
        <button type="button" class="register-tis">还有没有账号？</button>
    </a>--%>

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
            $('.loginForm').fadeOut('slow', function(c){
                $('.loginForm').remove();
            });
        });

        $('#username,#password').change(function(){
            $('#submit').attr('value','Login').css('background','#3ea751');
        });
    });

</script>
</body>
</html>
