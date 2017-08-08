$(document).ready(function(){
    func_init();//when Page is ready, start 'func_init'
    $("#closeBth").click(func_close);
});

$("#createBtn").bind("click",function(){
   func_submit();
});

//check if tid is null, choose different function to init page
function func_init(){
   var tid = getQueryString("tid");
   if(tid != null){ // update content
       document.title = "修改";
       $("#createBtn").text("提交修改");
       $("#createBtn").attr("disabled", "disabled");
       func_show(tid);
    }else{//create new
       document.title = "新建";
       $("#enableBth").css("display","none");
       func_create();
   };
}

function func_submit(){
    var tid = getQueryString("tid");
    if(tid != null){//submit update
        submit_update(tid);
    }else{//submit new
        submit_create();
    }
}

function submit_update(tid){ // submit when update blog
    var title =  $("#input-38").attr("value");
    // var title2 =  $("#input-38").val();//they can get value
    var desc = $("#input-39").attr("value");
    var label = $("#input-40").attr("value");
    var content = editor.document.getBody().getHtml();
    $.ajax({
        type: "POST", url: "../admin/save", dataType:"JSON",
        data:{
            "tid": tid,
            "title": title.toString(),
            "desc": desc.toString(),
            "label": label.toString(),
            "content":content.toString()
        },
        success: function(data){
            //TODO process when success
            alert("success");
        },
        error: function (data) {
            //TODO process when failed
            alert("failed");
        }
    });
}

function submit_create(){ //submit when create new blog
    var title =  $("#input-38").val();
    alert(title);
    var desc = $("#input-39").attr("value");
    var label = $("#input-40").attr("value");
    var content = editor.document.getBody().getHtml();
    $.ajax({
        type: "POST", url: "../admin/saveBlog", dataType:"JSON",
        data:{
           "title": title,
           "desc": desc,
           "label": label,
           "content":content
        },
        async:false,
        success: function(data){
            //TODO process when success
            alert("success");
        },
        error: function (data) {
            //TODO process when failed
            alert("failed");
        }
    });
}

//show blog
function func_show(tid) {
    $.ajax({
        type: "POST", url: "../admin/showBlog", dataType: "JSON",
        data: {
            "tid": tid
        },
        success: function (data) {
            if (data == null) {
                alert("数据返回异常");
            } else {
                var obj = data;//解析json字符串为json对象形式
                var title = obj.title;
                var desc = obj.decoration;
                var content = obj.content;
                var label = obj.label.replace(","," ");

                $("#input-38").attr("value",title);
                $("#input-39").attr("value",desc);
                $("#input-40").attr("value",label);
                editor.setData(content);
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

function func_close(){
    open(location, '_self').close();
}

function func_enable(){
    $("#createBtn").removeAttr("disabled");
}

//create blog
function func_create(){

}