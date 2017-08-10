/**
 * Created by eli9 on 7/27/2017.
 */

$(document).ready(function(){
    func_init();
    $.getScript("../js/page.js");//加载JS文件
    $.getScript("../js/page.js", function () {
        hide();
    });
    pageRoll();
});

function func_init(){
    var pageSize=5;
    $.ajax({
        type: "POST", url : "../admin/show", dataType : "JSON",
        data : {
            "uId": getQueryString("uId")
        },
        async: false, //要求同步的操作
        success: function (data) {//处理返回的数据
            if(data.msg == "Session"){
                func_error();
            }else if(data == null) {
                alert("后台返回数据错误");
            }else{
                //接收后台的数据
                var obj = data;//解析json字符串为json对象形式
                var trStr = '';
                for (var i = 0; i < obj.length; i++) {
                    trStr += '<tr><td>';
                    trStr += '<h2 class="blogTitle"><a href="../backend/editor.html?tid=' + obj[i].tid + '">';
                    trStr += obj[i].title + '</a></h2>';
                    trStr += '<span>' + obj[i].content.substring(0, +obj[i].content.indexOf("</p>") + 4) + '</span>';
                    trStr += '<div><a href="../backend/editor.html?tid=' + obj[i].tid + '" target="_blank">阅读全文>></a></div>';
                    trStr += '<hr/></td>';
                }
                var len = obj.length;//记录总数
                var value = obj.length % pageSize;
                var pageNum = (value == 0 ? value : value + 1);////count of pages
                $('#blogTable').html(trStr);//运用HTML的方法将拼接的table添加到dom
                $('#spanTotalInfo').text(len);
                $('#spanTotalPage').text(pageNum);
            }
        },
        error: function(){
            $("#valueShow").text("返回异常");
        }
    });
}

function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
}

function pageRoll(){//页面滚动函数
    //当滚动条的位置处于距顶部100像素以下时，跳转链接出现，否则消失
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
