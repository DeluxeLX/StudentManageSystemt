<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
	<!-- 页面meta -->
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">


	<title>学生信息管理系统</title>
	<meta name="description" content="AdminLTE2定制版">
	<meta name="keywords" content="AdminLTE2定制版">


	<!-- Tell the browser to be responsive to screen width -->
	<meta
			content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
			name="viewport">
	<!-- Bootstrap 3.3.6 -->
	<!-- Font Awesome -->
	<!-- Ionicons -->
	<!-- iCheck -->
	<!-- Morris chart -->
	<!-- jvectormap -->
	<!-- Date Picker -->
	<!-- Daterange picker -->
	<!-- Bootstrap time Picker -->
	<!--<link rel="stylesheet" href="${pageContext.request.contextPath}/${pageContext.request.contextPath}/${pageContext.request.contextPath}/plugins/timepicker/bootstrap-timepicker.min.css">-->
	<!-- bootstrap wysihtml5 - text editor -->
	<!--数据表格-->
	<!-- 表格树 -->
	<!-- select2 -->
	<!-- Bootstrap Color Picker -->
	<!-- bootstrap wysihtml5 - text editor -->
	<!--bootstrap-markdown-->
	<!-- Theme style -->
	<!-- AdminLTE Skins. Choose a skin from the css/skins
           folder instead of downloading all of them to reduce the load. -->
	<!-- Ion Slider -->
	<!-- ion slider Nice -->
	<!-- bootstrap slider -->
	<!-- bootstrap-datetimepicker -->

	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->


	<!-- jQuery 2.2.3 -->
	<!-- jQuery UI 1.11.4 -->
	<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
	<!-- Bootstrap 3.3.6 -->
	<!-- Morris.js charts -->
	<!-- Sparkline -->
	<!-- jvectormap -->
	<!-- jQuery Knob Chart -->
	<!-- daterangepicker -->
	<!-- datepicker -->
	<!-- Bootstrap WYSIHTML5 -->
	<!-- Slimscroll -->
	<!-- FastClick -->
	<!-- iCheck -->
	<!-- AdminLTE App -->
	<!-- 表格树 -->
	<!-- select2 -->
	<!-- bootstrap color picker -->
	<!-- bootstrap time picker -->
	<!--<script src="${pageContext.request.contextPath}/${pageContext.request.contextPath}/${pageContext.request.contextPath}/plugins/timepicker/bootstrap-timepicker.min.js"></script>-->
	<!-- Bootstrap WYSIHTML5 -->
	<!--bootstrap-markdown-->
	<!-- CK Editor -->
	<!-- InputMask -->
	<!-- DataTables -->
	<!-- ChartJS 1.0.1 -->
	<!-- FLOT CHARTS -->
	<!-- FLOT RESIZE PLUGIN - allows the chart to redraw when the window is resized -->
	<!-- FLOT PIE PLUGIN - also used to draw donut charts -->
	<!-- FLOT CATEGORIES PLUGIN - Used to draw bar charts -->
	<!-- jQuery Knob -->
	<!-- Sparkline -->
	<!-- Morris.js charts -->
	<!-- Ion Slider -->
	<!-- Bootstrap slider -->
	<!-- bootstrap-datetimepicker -->
	<!-- 页面meta /-->

	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/morris/morris.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.theme.default.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/select2/select2.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/adminLTE/css/skins/skin-purple.min.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.skinNice.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/bootstrap-slider/slider.css">
	<link rel="stylesheet"
		  href="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
	<style>
		.hero {
			height: 80vh;
			color: #000000;
			display: flex;
			flex-direction: column;
			justify-content: center;
			align-items: center;
			text-align: center;
		}

		.hero h1 {
			font-size: 46px;
			margin: -20px 0 20px;
		}

		.hero p {
			font-size: 16px;
			letter-spacing: 1px;
		}

		.hero strong {
			font-size: 22px;
			letter-spacing: 1px;
		}
	</style>
</head>

<body class="hold-transition skin-purple sidebar-mini">

<div class="wrapper">

	<!-- 页面头部 -->
	<jsp:include page="header.jsp"/>
	<!-- 页面头部 /-->

	<!-- 导航侧栏 -->
	<jsp:include page="aside.jsp"/>
	<!-- 导航侧栏 /-->

	<!-- 内容区域 -->
	<!-- @@master = admin-layout.html-->
	<!-- @@block = content -->

	<div class="content-wrapper">

		<!-- 内容头部 -->
		<div class="hero">
			<%--<h1>Welcome to 507 AdminTLE</h1>--%>
			<h1>Student Management System</h1>
			<br><br>
			<p>
				Designed by Liao Zihao of
				<strong>Kingcola-ICG</strong>.
			</p>
		</div>
		<!-- 正文区域 /-->

	</div>
	<!-- @@close -->
	<!-- 内容区域 /-->

	<!-- 底部导航 -->
	<footer class="main-footer">
		<div class="pull-right hidden-xs">
			<b>Version</b> 1.0.8
		</div>
		<strong>Copyright &copy; 2021-2022 <a
				href="#">KingCola-ICG</a>.
		</strong> All rights reserved.
	</footer>
	<!-- 底部导航 /-->

</div>


<script
		src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/jQueryUI/jquery-ui.min.js"></script>
<script>
	$.widget.bridge('uibutton', $.ui.button);
</script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/raphael/raphael-min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/morris/morris.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/sparkline/jquery.sparkline.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/knob/jquery.knob.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/daterangepicker/moment.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/datepicker/bootstrap-datepicker.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/fastclick/fastclick.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/adminLTE/js/app.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/select2/select2.full.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/markdown.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/to-markdown.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/ckeditor/ckeditor.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/datatables/jquery.dataTables.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/chartjs/Chart.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.resize.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.pie.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.categories.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.min.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-slider/bootstrap-slider.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script>
	$(document).ready(function() {
		// 选择框
		$(".select2").select2();

		// WYSIHTML5编辑器
		$(".textarea").wysihtml5({
			locale : 'zh-CN'
		});
	});

	// 设置激活菜单
	function setSidebarActive(tagUri) {
		var liObj = $("#" + tagUri);
		if (liObj.length > 0) {
			liObj.parent().parent().addClass("active");
			liObj.addClass("active");
		}
	}

	$(document).ready(function() {

		// 激活导航位置
		setSidebarActive("admin-datalist");

		// 列表按钮
		$("#dataList td input[type='checkbox']").iCheck({
			checkboxClass : 'icheckbox_square-blue',
			increaseArea : '20%'
		});
		// 全选操作
		$("#selall").click(function() {
			var clicks = $(this).is(':checked');
			if (!clicks) {
				$("#dataList td input[type='checkbox']").iCheck("uncheck");
			} else {
				$("#dataList td input[type='checkbox']").iCheck("check");
			}
			$(this).data("clicks", !clicks);
		});
	});
</script>
</body>

</html>