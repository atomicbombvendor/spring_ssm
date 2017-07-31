/**
 * Created by eli9 on 7/27/2017.
 */

$(document).ready(function(){
    func_init();
});

function func_init(){
    var pageSize=5;
    $.ajax({
        type: "POST", url : "../admin/show", dataType : "JSON",
        data : {
            "uId": getQueryString("uId")
        },
        async: false,
        success: function (data) {//处理返回的数据
            if(data != null){
                //接收后台的数据
                var obj = data;//解析json字符串为json对象形式
                var trStr='';
                for(var i=0; i<obj.length; i++){
                    trStr += '<tr><td>';
                    trStr += '<h2 class="blogTitle"><a href="showBlogDetail?tid='+obj[i].tid+'">';
                    trStr += obj[i].title+'</a></h2>';
                    trStr += '<span>'+obj[i].content.substring(0, +obj[i].content.indexOf("</p>")+4)+'</span>';
                    trStr += '<div><a href="showBlogDetail?tid='+obj[i].tid+'"</a>阅读全文>></div>';
                    trStr += '<hr/></td>';
                }
                var len = obj.length;//记录总数
                var value = obj.length%pageSize;
                var pageNum = (value==0?value:value+1);////count of pages
                $('#blogTable').html(trStr);//运用HTML的方法将拼接的table添加到dom
                $('#spanTotalInfo').text(len);
                $('#spanTotalPage').text(pageNum);
            }else{
                $("#valueShow").text("数据返回异常");
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
