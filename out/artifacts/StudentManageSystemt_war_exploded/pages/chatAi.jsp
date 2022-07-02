<%--
  Created by IntelliJ IDEA.
  User: liaozihao
  Date: 2022/6/7
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: liaozihao
  Date: 2022/6/7
  Time: 8:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>在线客服</title>

    <meta name="description" content="AdminLTE2定制版">
    <meta name="keywords" content="AdminLTE2定制版">
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">

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
        .avatar {
            width: 50px;
            height: 50px;
            border-radius: 50px;
        }
    </style>
</head>
<body>
<script src="https://cdn.bootcss.com/vue/2.5.20/vue.min.js"></script>

<!-- 页面头部 -->
<jsp:include page="header.jsp"/>
<!-- 页面头部 /-->

<!-- 导航侧栏 -->
<jsp:include page="aside.jsp"/>
<!-- 导航侧栏 /-->

<div id="app">
    <div class="chat-list">
        <div v-for="item in msgList">
            <div class="robot" v-if="item.type == 1">
                <img class="avatar" src="${pageContext.request.contextPath}/img/webp.jpg" alt="图片无法显示">
                <span class="robot-span">{{item.msg}}</span>
            </div>

            <div class="people" v-if="item.type == 0">
                <img class="avatar" src="${pageContext.request.contextPath}/img/liaozihaoUser.jpg" alt="图片无法显示">
                <span class="people-span">{{item.msg}}</span>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    new Vue({
        el: "#app",
        data: {
            msgList: [
                {
                    type: 1,
                    msg: "你好呀，我是智能AI"
                },
                {
                    type: 0,
                    msg: "你好，lzh"
                }
            ]
        },
        methods: {

        },
        created() {
            console.log("--vue加载成功！--");
        }
    })
</script>
<%--<div class="wrap">
    <div class="container">
        <ul class="msg"></ul>
    </div>
</div>
<hr/>
<form onsubmit="return false">
    <p class="bar-group">
        <input type="text" id="umsg" placeholder="说点什么..."/>
        <input type="submit" value="发送" onclick="send()"/>
        <input type="reset" value="重输" onclick="umsg.focus()"/>
        <input type="button" value="清屏" onclick="clearTxt()"/>
    </p>
</form>--%>
<%--<script>
    var container = document.querySelector('.container');
    var msg = document.querySelector('.msg');
    var umsg = document.querySelector('#umsg');

    // 发送数据
    function send() {
        if (umsg.value) {	// 非空

            // 创建一个实例<li></li>标签
            var uli = document.createElement('li');
            uli.textContent = '你：' + umsg.value;
            msg.appendChild(uli);

            // URL查询参数实例，直接对象格式，省去了很多麻烦
            var  reqParams = new URLSearchParams({
                app_key: '612d6926-5036-4521-9b85-b2dbe1a7f698',	// 免费接口
                user_id: 0,	    // 用户唯一标识（测试的话不用管）
                q: umsg.value	// 输入的内容
            });

            // 头信息实例
            var reqHeader = new Headers();
            reqHeader.append('Content-Type', 'application/x-www-form-urlencoded');
            // reqHeader.append('Content-Type', 'application/json');

            // 请求实例
            var request = new Request('http://api.ruyi.ai/v1/message?' + reqParams, {
                method: 'GET'	// 请求方式【只接受GET请求】
            });

            fetch(request)	// 发送请求
                .then(res => res.json())	// 转为 JSON
                .then(res => {	// 处理数据
                    // 普通结果
                    // var retval = res.result.intents[0].result.text.replace(/\&name/g, '如宝');

                    // 微信端结果
                    // var retval = res.result.intents[0].outputs[0].property.text;

                    // 智能硬件端结果
                    var retval = res.result.intents[0].outputs[1].property.text;

                    var hli = document.createElement('li');
                    hli.textContent = '智能AI回复：' + retval;
                    msg.appendChild(hli);
                    container.scrollTop = container.scrollHeight; // 滚动条置底
                });
            umsg.value = '';
        }
        umsg.focus();	// 聚焦
        container.scrollTop = container.scrollHeight; // 滚动条置底
    }

    // 清空屏幕
    function clearTxt() {
        msg.innerHTML = null;
        umsg.value = null;
        umsg.focus();
    }

    umsg.focus();	// 聚焦
</script>--%>
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
            locale: 'zh-CN'
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

    // 激活使时间选择框样式
    $('#datepicker').datepicker({
        autoclose: true,
        format: 'yyyy/mm/dd'
    });

    $(document).ready(function() {
        // 激活导航位置
        setSidebarActive("admin-invoice");
    });
</script>
</body>
</html>

