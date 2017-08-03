/**
 * Created by eli9 on 8/3/2017.
 */
$(document).ready(function () {
    func_init();
    pageRolling();
})
function func_init(){
    $.ajax({
        type: "POST", url: "../admin/label", dataType: "JSON",
        data:{
            "label": getQueryString("labelName")
        },
        async: false, //要求同步的操作
        success: function (data) {
            if(data!=null){
                //接收后台的数据
                var obj = data;//得到json的對象
                var value ='';//拼接的字符
                for(var i=0; i<obj.length; i++){
                    var o = obj[i];
                    value += '<div class="cd-timeline-block">';
                    value += '<div class="cd-timeline-img cd-picture">';
                    value += '<img src="../resource/img/cd-icon-picture.svg" alt="Picture"></div>';
                    value += '<div class="cd-timeline-content">';
                    value += '<h2>' + o.title +'</h2>';
                    value += '<p>' + o.content.substring(0, o.content.indexOf("</p>")+4) + '</p>';
                    value += '<a href="showBlogDetail?tid=' + o.tid + '">阅读全文>></a>';
                    value += '<span class="cd-date">' + o.updateTime.toString().substring(0,10) + '</span>';
                    value += '</div></div>';
                }
                $('#cd-timeline').html(value);
                $('#top_title').text(getQueryString("labelName"));
                document.title = getQueryString("labelName");
            }else {
                $('#cd-timeline').html("没有内容");
            }
        },error: function(){
            $('#valueShow').text("获取数据异常");
        }
    })
}

function getQueryString(name){
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
    var r = window.location.search.substr(1).match(reg);
    if(r != null) return unescape(r[2]);
    return null;
}