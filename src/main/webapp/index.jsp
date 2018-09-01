<!doctype html>
<html lang="en">
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <title>后台登录</title>
    <meta username="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta username="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <!--<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />-->
    <link rel="stylesheet" href="plug/x-admin/css/font.css">
    <link rel="stylesheet" href="plug/x-admin/css/xadmin.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/common.js"></script>
    <script src="plug/x-admin/lib/layui/layui.js" charset="utf-8"></script>
    <script src="plug/x-admin/js/xadmin.js"></script>

</head>
<body class="login-bg">

<div class="login layui-anim layui-anim-up">
    <div class="message">后台管理登录</div>
    <div id="darkbannerwrap"></div>

    <form method="post" class="layui-form" >
        <input name="username" placeholder="用户名"  type="text" lay-verify="required" class="layui-input" value="admin">
        <hr class="hr15">
        <input name="password" lay-verify="required" placeholder="密码"  type="password" class="layui-input" value="admin">
        <hr class="hr15">
        <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit">
        <hr class="hr20" >
    </form>
</div>

<script>
    $(function  () {
        layui.use('form', function(){
            var form = layui.form;
            form.on('submit(login)', function(data){
                Ajax({
                    api:"user/login",
                    data:data.field,
                    callback_success:function (res) {
                      //location.href='index.html';
                        Redirect("");
                    }
                });
                return false;
            });
        });
    });


</script>

</body>
</html>