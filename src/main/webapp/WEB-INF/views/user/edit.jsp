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
    <form id="layui-form" class="layui-form"></form>
</div>

<script>
    $(function () {
        var actionType = getUrlParam("actionType");
        var itemData = null;

        if (actionType == 2) {
            Ajax({
                api: "page/getEntityById",
                data: {"pageId": "1", "itemId": getUrlParam("itemId")},
                callback_success: function (data) {
                    itemData = data;
                    createIdInput(itemData);
                    bindFields(actionType, itemData);
                }
            });

        }
        else {
            bindFields(actionType, itemData);
        }
    });


    function createField(item, itemData) {
        var item_div = document.createElement("div");
        item_div.setAttribute("class", "layui-form-item");

        //Label文本
        var labelElement = document.createElement("label");
        labelElement.setAttribute("class", "layui-form-label");
        labelElement.setAttribute("for", item.CODE);
        labelElement.innerHTML = item.DISPLAYNAME;

        if (item.ISREQUIRED) {
            var spanElement = document.createElement("span");
            spanElement.setAttribute("class", "x-red");
            spanElement.innerHTML = "*";
            labelElement.appendChild(spanElement);
        }

        item_div.appendChild(labelElement);

        //Input 输入框
        var inputElement = document.createElement("input");
        inputElement.setAttribute("type", "text");
        inputElement.setAttribute("id", item.CODE);
        inputElement.setAttribute("name", item.CODE);
        if (item.ISREQUIRED) {
            inputElement.setAttribute("lay-verify", "required");
        }
        if (itemData != null && itemData.hasOwnProperty(item.CODE)) {
            inputElement.setAttribute("value", itemData[item.CODE]);
        }
        inputElement.setAttribute("autocomplete", "off");
        inputElement.setAttribute("class", "layui-input");

        var input_div = document.createElement("div");
        input_div.setAttribute("class", "layui-input-inline");
        input_div.appendChild(inputElement);

        item_div.appendChild(input_div);

        //提示框
        var msg_div = document.createElement("div");
        msg_div.setAttribute("class", "layui-form-mid layui-word-aux");
        msg_div.innerHTML = item.MESSAGE;

        item_div.appendChild(msg_div);

        $(".layui-form").append(item_div);
    }

    function createButton() {
        var labelElement = document.createElement("label");
        labelElement.setAttribute("class", "layui-form-label");

        var buttonElement = document.createElement("button");
        buttonElement.setAttribute("lay-submit", "");
        buttonElement.setAttribute("lay-filter", "add");
        buttonElement.setAttribute("class", "layui-btn");
        buttonElement.innerHTML = "保存";

        var item_div = document.createElement("div");
        item_div.setAttribute("class", "layui-form-item");
        item_div.appendChild(labelElement);
        item_div.appendChild(buttonElement);
        $(".layui-form").append(item_div);
    }

    function createIdInput(itemData) {
        var code = "id";
        var inputElement = document.createElement("input");
        inputElement.setAttribute("type", "hidden");
        inputElement.setAttribute("id", code);
        inputElement.setAttribute("name", code);
        inputElement.setAttribute("value", itemData[code]);
        $(".layui-form").append(inputElement);
    }

    function bindFields(actionType, itemData) {
        Ajax({
            api: "page/getColumsByAction",
            data: {"pageId": "1", "actionType": actionType},
            callback_success: function (res) {
                $.each(res, function (i, item) {
                    createField(item, itemData);
                });
                createButton();

                layui.use(['form', 'layer'], function () {
                    var form = layui.form;
                    var layer = layui.layer;
                    form.render();

                    //监听提交
                    form.on('submit(add)', function (data) {
                        //发异步，把数据提交给php
                        Ajax({
                            api: "page/saveBaseForm",
                            data: {"pageId": 1, "keyValue": data.field},
                            callback_success: function (res) {
                                if (res > 0) {
                                    layer.alert("保存成功", {icon: 6}, function () {
                                        var index = parent.layer.getFrameIndex(window.name); // 获得frame索引
                                        parent.layui.table.reload('tb', {page: {curr: 1}});
                                        parent.layer.close(index); //关闭当前frame
                                    });
                                }
                                else {
                                    layer.alert("保存失败");
                                }
                            }
                        });
                        return false;
                    });
                });
            }
        });
    }

</script>

</body>

</html>