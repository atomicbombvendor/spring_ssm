$(document).ready(function(){
    func_init();//when Page is ready, start 'func_init'
    $("#closeBth").click(func_close);
});

function func_init(){
   var tid = getQueryString("tid");
   if(tid != null){//表示前台有参数传入，需要做修改
    $.ajax({
        type: "POST", url : "../admin/blog", dataType : "JSON",
        data : {
            "tid": tid
        },
        async: false, //要求同步的操作
        success: function (data) {//处理返回的数据
            if(data != null){
                //接收后台的数据
                var obj = data;//解析json字符串为json对象形式
                var trStr='';
                trStr += '<tr><td>';
                trStr += '<h2 class="blogTitle"><a href="showBlogDetail?tid='+obj.tid+'">';
                trStr += obj.title+'</a></h2>';
                trStr += '<span>'+obj.content.substring(0, +obj.content.indexOf("</p>")+4)+'</span>';
                trStr += '<div><a href="showBlogDetail?tid='+obj.tid+'"</a>阅读全文>></div>';
                trStr += '<hr/></td>';
                $('#blogTable').html(trStr);//运用HTML的方法将拼接的table添加到dom
                document.title = "修改";
                $("#createBtn").attr("disabled","disabled");
                $("#createBtn").attr("value","提交");
            }else{
                $("#valueShow").text("数据返回异常");
            }
        },
        error: function(){
            $("#valueShow").text("返回异常");
        }
    })}else{//新建页面
       document.title = "新建";
       $("#enableBth").css("display","none");
   };
}

function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
}

function func_close(){
    open(location, '_self').close();
}
function func_enable(){
    $("#createBtn").removeAttr("disabled");
}