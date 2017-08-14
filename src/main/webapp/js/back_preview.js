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
                var userName = obj.user_name;
                var label = new Array();
                label = obj.label.split(" ");
                var createTime = getDate(obj.create_time);
                var updateTime = getDate(obj.alter_time);

                document.title = title;
                $("#title").text(title);
                $("#content").html(content);
                $("#desc").html(desc);
                $("#userName").text(userName);
                var labelValue='<span class="post-meta-item-text">分类 ';
                for(var i=0; i<label.length;  i++){
                    labelValue += '&nbsp;';
                    labelValue += '<a href="../backend/timeline.html?labelName='+label[i]+'">'+label[i]+'</a>';
                }
                labelValue += '</span>';
                $("#label").html(labelValue);
                $("#create").text(createTime);
                $("#update").text(updateTime);
                $("#create").attr("datetime",createTime);
                $("#update").attr("datetime",updateTime);
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

//获得年月日 得到日期
function getDate(str){
    var oDate = new Date(str),
        oYear = oDate.getFullYear(),
        oMonth = oDate.getMonth()+1,
        oDay = oDate.getDate(),
        oHour = oDate.getHours(),
        oMin = oDate.getMinutes(),
        oSen = oDate.getSeconds(),
        oTime = oYear +'-'+ getZeroFormat(oMonth) +'-'+ getZeroFormat(oDay);//最后拼接时间
    return oTime;
};

//补0操作
function getZeroFormat(num){
    if(parseInt(num) < 10){
        num = '0'+num;
    }
    return num;
}
/**
 * Created by eli9 on 8/10/2017.
 */
