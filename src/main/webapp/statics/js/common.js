//发送ajax请求
function Ajax(params) {
    if (!params) throw "没有参数";
    if (!params.api) throw "请输入api";

    var method = params.method || "post";
    var api = params.api || "";
    var data = params.data || {};
    var isSync = params.isSync || true;
    var callback_success = params.callback_success || null;
    var callback_fail = params.callback_fail || null;
    var callback_end = params.callback_end || null;

    jQuery.support.cors = true;
    var req = $.ajax({
        type: method,
        url: api,
        sync:isSync,
        data: JSON.stringify(data),
        contentType: "application/json",
        dataType: 'json',
        timeout: 600000,
        beforeSend: function (request) {

        },
        success: function (res) {
            if (res.resultCode != 0) {
                layer.msg(res.message);
                return;
            }
            callback_success(res.body);
        },
        error: function (req, msg, ex) {
            layer.msg("请求异常，请稍后重试！");
            if (callback_end) callback_end();
        }
    });

    return req;
}

function Redirect(url) {
    if (url.length == 0)
        location.href = 'main';
    else
        location.href = 'page?viewName=' + encodeURIComponent(url);
}

//获取url中的参数
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");     //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);          //匹配目标参数
    if (r != null) return unescape(r[2]);
    return null;          //返回参数值
}
