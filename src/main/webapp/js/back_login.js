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
                //跳转到登录成功页面
                $("#msg").text("成功");
            }else{
                $("#msg").text("登录异常");
            }
        },
        error: function(){
            $("#msg").text("登录失败，请检查用户名或密码");
        }
    });
}