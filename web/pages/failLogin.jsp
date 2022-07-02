<%--
  Created by IntelliJ IDEA.
  User: liaozihao
  Date: 2022/6/5
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>登录页面</title>

    <meta
            content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
            name="viewport">

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">

    <style type="text/css">
        .image {
            width: 100%;
            height: 100%;
            display: flex;
            position: absolute;
            top: 0;
            left: 0;
            z-index: -1;
            background-repeat: no-repeat;
            background-size: cover;
            background-position: bottom center;
        }
    </style>
</head>

<body class="login-page" style="padding-top: 160px">
<img class="image" src="${pageContext.request.contextPath}/img/LoginPage.jpg" alt="图片无法显示">
<div class="login-box" style="margin-right: 120px; margin-top: 0px">
    <div class="login-logo">
        <a href="#">
            <b>ITLZH </b>
            学生管理系统
        </a>
    </div>
    <!-- /.login-logo -->
    <div class="login-box-body" style="border-radius: 20px; box-shadow: 0 5px 10px #bfbfbf">
        <p class="login-box-msg">登录系统</p>
        <p style="color: #ff2323; height: 10px">用户名或密码有误，请重新输入...</p>
        <form action="${pageContext.request.contextPath}/login.do" method="post">
            <div class="form-group has-feedback">
                <input type="text" name="username" class="form-control" placeholder="用户名">
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback" style="margin-bottom: 30px">
                <input type="password" name="password" class="form-control" placeholder="密码">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck">
                        <label><input type="checkbox"> 记住密码</label>
                    </div>
                </div>
                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
                </div>
                <!-- /.col -->
            </div>
        </form>

    </div>
    <!-- /.login-box-body -->
</div>
<!-- /.login-box -->
<div class="pull-right hidden-xs" style="margin-right: 90px; margin-top: 90px; font-size: 12px; ">
    <b>Version</b> 1.0.8
    <strong>
        Copyright &copy; 2021-2022
        <a href="#">KingCola-ICG</a>.
    </strong> All rights reserved.
    <div style="margin-top: 10px">
        沪ICP备12345678号&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;沪公网安备01234567890123号
    </div>
</div>


<!-- jQuery 2.2.3 -->
<!-- Bootstrap 3.3.6 -->
<!-- iCheck -->
<script
        src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
<script>
    $(function() {
        $('input').iCheck({
            checkboxClass : 'icheckbox_square-blue',
            radioClass : 'iradio_square-blue',
            increaseArea : '50%' // optional
        });
    });
</script>
</body>

</html>
