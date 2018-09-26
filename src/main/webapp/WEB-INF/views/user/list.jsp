<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8"/>
    <link rel="stylesheet" href="plug/x-admin/css/font.css">
    <link rel="stylesheet" href="plug/x-admin/css/xadmin.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/common.js"></script>
    <script src="plug/x-admin/lib/layui/layui.js" charset="utf-8"></script>
    <script src="plug/x-admin/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="js/html5.min.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="x-body">
    <xblock id="toolbar">
        <button class="layui-btn" onclick="x_admin_show('新增','page?viewName=user/edit&actionType=1')"><i
                class="layui-icon">&#xe654;</i>新增
        </button>
        <button class="layui-btn layui-btn-normal" onclick="openDialog('编辑','page?viewName=user/edit&actionType=2')"><i
                class="layui-icon">&#xe642;</i>编辑
        </button>
        <button class="layui-btn layui-btn-danger" onclick="deletes()"><i class="layui-icon"></i>删除</button>
        <span style="line-height:40px;float: right">
        <form class="layui-form layui-col-md12 x-so">
            <input type="text" name="username" placeholder="请输入用户名" autocomplete="off" class="layui-input">
            <button class="layui-btn" lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
        </span>
    </xblock>
    <table id="tb"></table>
</div>

<script>
    $(function () {
        Ajax({
            api: "page/getColumns?pageid=1",
            callback_success: function (res) {
                var clos = [];
                clos.push({
                    checkbox: true,
                    fixed: true
                });
                $.each(res, function (i, item) {
                    var clo = {
                        field: item.code,
                        title: item.displayName
                    };
                    if (item.hasOwnProperty("width")) clo.width = item.width;
                    if (item.hasOwnProperty("sort")) clo.sort = item.sort;
                    if (item.hasOwnProperty("fixed")) clo.fixed = item.fixed;
                    if (item.hasOwnProperty("templet")) {
                        //clo.templet = item.templet;
                        var fun = "window.fun=" + item.templet;
                        clo.templet = eval(fun);
                    }
                    clos.push(clo);
                });
                layui.use('table', function () {
                    var table = layui.table;
                    table.render({
                        elem: '#tb',
                        url: 'page/getList',
                        page: true,
                        cols: [clos]
                    });
                });
            }
        });
    });

    function openDialog(title, url, w, h) {
        var checkStatus = layui.table.checkStatus('tb');
        var length = checkStatus.data.length;
        if (length != 1) {
            layer.alert("请选择一条记录");
            return false;
        }
        url += "&itemId=" + checkStatus.data[0]["id"];
        x_admin_show(title, url, w, h);
    }


    function deletes() {
        var checkStatus = layui.table.checkStatus('tb');
        var length = checkStatus.data.length;
        if (length < 1) {
            layer.alert("请选择至少一条记录");
            return false;
        }

        var ids = new Array();
        $.each(checkStatus.data, function (index, value) {
            ids.push(value["id"]);
        });

        layer.confirm('确认删除？', function (index) {
            Ajax({
                api: "page/deleteItems",
                data: {"pageId": "1", "ids": ids},
                callback_success: function (res) {
                    if (res > 0) {
                        layui.table.reload('tb', {page: {curr: 1}});
                        layer.msg('删除成功', {icon: 1});
                    } else {
                        layer.alert("删除失败");
                    }
                }
            });
        });
    }
</script>
</body>

</html>
