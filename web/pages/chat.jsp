<%--
  Created by IntelliJ IDEA.
  User: liaozihao
  Date: 2022/5/27
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
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
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
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
        .avatar {
            width: 40px;
            height: 40px;
            border-radius: 40px;
        }
        .chat-list {
            overflow: auto;
            height: 428px;
        }
        .robot {
            display: flex;
            justify-content: flex-start;
            margin: 15px;
        }
        .robot-span {
            padding: 15px;
            background-color: #eeeeee;
            border-radius: 20px;
            box-shadow: 0 3px 10px #bfbfbf;
            margin: -6px 10px 10px 20px;
            letter-spacing: 2px;
            white-space: pre;
        }
        .people {
            display: flex;
            justify-content: flex-end;
            margin: 15px;
        }
        .people-span {
            padding: 15px;
            background-color: #94bde3;
            border-radius: 20px;
            box-shadow: 0 3px 10px #bfbfbf;
            margin: -6px 20px 10px 10px;
            letter-spacing: 2px;
            white-space: pre;
        }
        .textArea {
            width: 1240px;
            position: fixed;
            bottom: 60px;
            right: 25px;
            z-index: 5;
        }
        .send {
            position: fixed;
            bottom: 70px;
            right: 50px;
            z-index: 10;
        }
    </style>
</head>

<body class="hold-transition skin-purple sidebar-mini">
<script src="https://cdn.bootcss.com/vue/2.5.20/vue.min.js"></script>

<div class="wrapper">
    <jsp:include page="header.jsp"/>
    <jsp:include page="aside.jsp"/>
    <div class="content-wrapper">
        <section class="content-header">
            <h1>
                智能AI客服
                <small>Artificial Intelligence</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">智能AI客服</a></li>
            </ol>
        </section>
        <section class="invoice">
            <div id="app">
                <div class="container">
                    <div class="chat-list">
                        <div v-for="item in msgList" class="chat-list2">
                            <div class="robot" v-if="item.type == 1">
                                <img class="avatar" src="${pageContext.request.contextPath}/img/webp.jpg" alt="图片无法显示">
                                <span class="robot-span">{{item.msg}}</span>
                            </div>
                            <div class="people" v-if="item.type == 0">
                                <span class="people-span">{{item.msg}}</span>
                                <img class="avatar" src="${pageContext.request.contextPath}/img/liaozihaoUser.jpg" alt="图片无法显示">
                            </div>
                        </div>
                    </div>
                    <div class="chat-btn">
                        <form class="sendMsgForm" v-on:submit.prevent="send">
                            <div class="col-md-12 data rowHeight2x">
                                <label>
                                    <textarea class="form-control textArea" cols="150" rows="5" placeholder="请输入..."
                                          style="resize: none" id="textArea" v-model="msgUser">{{msgUser}}</textarea>
                                    <button class="btn btn-primary send" type="submit">发送</button>
                                </label>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
        <div class="clearfix"></div>
    </div>
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 1.0.8
        </div>
        <strong>Copyright &copy; 2021-2022 <a
                href="http://www.itcast.cn">KingCola-ICG</a>.
        </strong> All rights reserved.
    </footer>
</div>

<script type="text/javascript">

    new Vue({
        el: "#app",
        data: {
            msgList: [
                {
                    type: 1,
                    msg: "你好呀，我是智能AI客服机器人！"
                },
                {
                    type: 1,
                    msg: "亲~以下是本网站最常咨询的问题:\n\n 1. 数据显示不出\n 2. 个别功能使用不了\n 3. 导出excel表失败\n " +
                        "4. 返回上一页显示要重新提交表单\n 5. 用浏览器打开网页发生抖动等错误\n 6. 表单提交失败\n 7. 如何获取管理员账号" +
                        "\n\n请问您遇到了什么问题呢？"
                }
            ],
            msgUser: ""
        },
        methods: {
            // 点击发送事件
            send() {
                console.log("进入到了send事件中...")
                let msgNow = this.msgUser
                let msgListNow = this.msgList

                // 对输入框的内容进行判空，如果是空则跳出弹窗
                if (msgNow === "" || msgNow == null) {
                    alert("不能发送空内容...")
                }

                // 清除输入框内容，实现发送功能; 清除后, 用户上一次的消息保存在msgNow中
                this.msgUser = ""

                // 将用户输入内容push进msgList中
                msgListNow.push({
                    type: 0,
                    msg: msgNow
                })
                this.msgList = msgListNow

                // 滚动条置底
                this.scrollAutoBottom()

                // 调用智能AI回复接口
                if (msgNow==="1"||msgNow==="2"||msgNow==="3"||msgNow==="4"||msgNow==="5"||msgNow==="6"||msgNow==="7"){
                    this.getCustomizationReply(msgNow)
                } else {
                    this.getArtificialReply(msgNow)
                }
            },

            getArtificialReply(sendMsg) {
                let replyMsg = null

                var reqParams = new URLSearchParams({
                    app_key: '612d6926-5036-4521-9b85-b2dbe1a7f698',	// 免费接口
                    user_id: 0,	    // 用户唯一标识（测试的话不用管）
                    q: sendMsg	    // 输入的内容
                })

                var reqHeader = new Headers();
                reqHeader.append('Content-Type', 'application/x-www-form-urlencoded');

                var request = new Request('http://api.ruyi.ai/v1/message?' + reqParams, {
                    method: 'GET'	           // 请求方式【只接受GET请求】
                });

                fetch(request)	// 发送请求
                    .then(res => res.json())	// 转为 JSON
                    .then(res => {	// 处理数据
                        console.log(res)
                        // 普通结果
                        // var retval = res.result.intents[0].result.text.replace(/\&name/g, '如宝');

                        // 微信端结果
                        // var retval = res.result.intents[0].outputs[0].property.text;

                        // 智能硬件端结果
                        replyMsg = res.result.intents[0].outputs[1].property.text;

                    });

                setTimeout(() => {
                    let msgListNow = this.msgList
                    msgListNow.push({
                        type: 1,
                        msg: replyMsg
                    })
                    this.msgList = msgListNow
                    this.scrollAutoBottom()
                }, 800)

            },

            getCustomizationReply(sendMsg) {
                if (sendMsg === "1" || sendMsg === "数据显示不出" || sendMsg === "第一个" || sendMsg === "一") {
                    replyMsg = "数据显示不出有可能是网络、服务器端未开启、数据\n库发生故障等，请问是哪里的数据无法显示呢？小A\n会及时联系管理员进行修复的"
                } else if (sendMsg === "2" || sendMsg === "个别功能使用不了" || sendMsg === "第二个" || sendMsg === "二") {
                    replyMsg = "可以刷新试试呀~刷新没用的话就是接口问题，工作\n人员正在对接口进行维护，暂停了功能呢"
                } else if (sendMsg === "3" || sendMsg === "导出excel表失败" || sendMsg === "第三个" || sendMsg === "三") {
                    replyMsg = "这个功能仅支持IE9以上的浏览器噢~对IE浏览器不太兼容"
                } else if (sendMsg === "4" || sendMsg === "返回上一页显示要重新提交表单" || sendMsg === "第四个" || sendMsg === "四") {
                    replyMsg = "这种情况就是本网站作者的锅了，设计不好，有小bug，请客户多担待。作者会努力修复bug的！"
                } else if (sendMsg === "5" || sendMsg === "用浏览器打开网页发生抖动等错误" || sendMsg === "第五个" || sendMsg === "五") {
                    replyMsg = "这种情况是浏览器不支持，建议使用谷歌浏览器和edge浏览器打开，作者使用IE浏览器或者\nQQ浏览器页面长宽在100%时也遇到了这种问题，" +
                        "可惜前端知识不够，无法解决这个bug。\n只知道bug来源于bootstrap3框架的问题"
                } else if (sendMsg === "6" || sendMsg === "表单提交失败" || sendMsg === "第六个" || sendMsg === "六") {
                    replyMsg = "表单提交失败可能是数据库外键或者并发问题，也可能是接口正在维护中噢~"
                } else if (sendMsg === "7" || sendMsg === "如何获取管理员账号" || sendMsg === "第七个" || sendMsg === "七") {
                    replyMsg = "哈哈哈~管理员qq在关于作者栏目里面哈"
                }
                setTimeout(() => {
                    let msgListNow = this.msgList
                    msgListNow.push({
                        type: 1,
                        msg: replyMsg
                    })
                    this.msgList = msgListNow
                    this.scrollAutoBottom()
                }, 800)
            },

            getOlamiReply(sendMsg) {
                var rqJson = {
                    "data": {
                        "input_type": 1,
                        "text": sendMsg
                    },
                    "data_type": "stt"
                }

                var rq = JSON.stringify(rqJson)
                console.log(rq)
                var appkey = "de839be23d504b2386f1c16cc81a4859"
                var api = "nli"
                var timestamp = new Date().getTime()
                var appSecret = "8e77582ca14848d0ad45c125ae802123"
                var sign = "06edee7d4d9728ea7ee29ad91d7946a7"

                // OLAMI请求示例
                var reqParams = new URLSearchParams({
                    appkey: appkey,
                    api: api,
                    timestamp: timestamp,
                    sign: sign,
                    rq: rq,
                    cusid: ""
                });

                // 头信息示例
                var reqHeader = new Headers();
                reqHeader.append('Content-Type', 'application/x-www-form-urlencoded')

                // 请求示例
                var req = new Request('https://cn.olami.ai/cloudservice/api?' + reqParams, {
                    method: 'GET',
                    mode: 'no-cors',
                    headers: reqHeader
                })
                console.log(req)
                // 发送请求
                fetch(req)
                .then(res => {
                    console.log(res)
                })
            },

            scrollAutoBottom() {
                this.$nextTick(() => {
                    let chatContainer = this.$el.querySelector('.chat-list');
                    chatContainer.scrollTop = chatContainer.scrollHeight
                })
            }
        },
        created() {
            console.log("--vue加载成功！--");
        }
    })

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


    $(document).ready(function() {
        // 激活导航位置
        setSidebarActive("admin-invoice");
    });
</script>

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
</body>

</html>

