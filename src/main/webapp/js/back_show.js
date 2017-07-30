/**
 * Created by eli9 on 7/27/2017.
 */

$(document).ready(function(){
    func_init();
});

function func_init(){
    $.ajax({
        type: "POST", url : "../admin/show", dataType : "JSON",
        data : {
            "uId": getQueryString("uId")
        },
        async: false,
        success: function (data) {//处理返回的数据
            if(data != null){
                //接收后台的数据
                alert(data);
                $("#valueShow").Text=data;
            }else{
                $("#valueShow").text("登录异常");
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
