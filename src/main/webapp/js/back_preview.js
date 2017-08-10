/**
 * Created by eli9 on 7/27/2017.
 */
$(document).ready(function(){
    func_init();
    pageRoll();
});

function func_init() {
    $.ajax({
        type: "POST", url: "../admin/showBlog", dataType: "JSON",
        data : {
            "tid": getQueryString("tid")
        },
        async: false, //要求同步的操作
        success: function (data) {
            if (data == null) {
                alert("数据返回异常");
            } else {
                var obj = data;//解析json字符串为json对象形式
                var title = obj.title;
                var desc = obj.decoration;
                var content = obj.content;
                var userName = obj.userName;
                var label = obj.label.replace(","," ");
                var createTime = obj.createTime;
                var updateTime = obj.updateTime;

                document.title = title;
                $("#content").val(content);
                $("#desc").val(desc);
                $("#userName").val(userName);
                $("#label").val(label);
            }
        },
        error: function () {
            alert("返回异常");
        }
    });
}

function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
}

//页面滚动函数
//当滚动条的位置处于距顶部100像素以下时，跳转链接出现，否则消失
function pageRoll(){
    $(function () {
        $(window).scroll(function(){
            if ($(window).scrollTop()>100){
                $("#back-to-top").fadeIn(500);
            }
            else {
                $("#back-to-top").fadeOut(500);
            }
        });

        //当点击跳转链接后，回到页面顶部位置
        $("#back-to-top").click(function(){
            //$('body,html').animate({scrollTop:0},1000);
            if ($('html').scrollTop()) {
                $('html').animate({ scrollTop: 0 }, 700);
                return false;
            }
            $('body').animate({ scrollTop: 0 }, 700);
            return false;
        });
    });
}

function func_error(){
    alert("Login info is expiration");
    window.location.href="../backend/login.html";
}
/**
 * Created by eli9 on 8/10/2017.
 */
