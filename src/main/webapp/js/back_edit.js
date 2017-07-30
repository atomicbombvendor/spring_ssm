/**
 * Created by eli9 on 7/27/2017.
 */
function func_submit(){
    $.ajax({
        type: "POST", url : "../admin/login", dataType : "JSON",
        data : {
            "userName": $("#userName").val(),
            "password": $("#password").val()
        },
        async: false,
        success: function (data) {//处理返回的数据
            if(data != null){
                //接收后台的数据
                $("#valueShow").hide();
            }else{
                $("#valueShow").text("登录异常");
            }
        },
        error: function(){
            $("#valueShow").text("返回异常");
        }
    });
}
