<%--
  Created by IntelliJ IDEA.
  User: liaozihao
  Date: 2022/6/21
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>学生信息管理系统</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <!-- Font Awesome -->
    <!-- Ionicons -->
    <!-- Theme style -->
    <!-- jQuery 2.2.3 -->
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.min.css">

</head>
<body>
<div class="wrapper">
    <!-- Main content -->
    <section class="invoice">
        <!-- title row -->
        <div class="row">
            <div class="col-xs-12">
                <h2 class="page-header">
                    <i class="fa fa-globe"></i> ITLZH, Inc.
                    <small class="pull-right">Date: ${dateNow}</small>
                </h2>
            </div>
            <!-- /.col -->
        </div>

        <!-- Table row -->
        <div class="row">
            <div class="col-xs-12 table-responsive">
                <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
                    <div class="pull-right bg-purple" style="font-size: 20px; padding: 15px; border-radius: 20px; margin-bottom: 20px">
                        平均学分绩： ${studentGPA}
                    </div>
                    <thead>
                    <tr>
                        <td>课程</td>
                        <td>学分</td>
                        <td>成绩</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${scoreList}" var="score">
                        <tr>
                            <td>${score.courseName}</td>
                            <td>${score.credit_hour}</td>
                            <td>${score.scoreStr}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <!--数据列表/-->
            </div>
            <!-- /.col -->
        </div>

    </section>
    <!-- /.content -->
</div>
<!-- ./wrapper -->

<script src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script>

    $(document).ready(function() {

        // 延迟1秒打印，等待图片载入
        setTimeout(function() {
            window.print();
        }, 1000);
    });

</script>
</body>
</html>

