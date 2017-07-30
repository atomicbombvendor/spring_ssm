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
                //alert(typeof data);
                //如果为object，可以尝试直接使用data.key获取属性；
                //如果为string，那么必须进行解析为json object，才可以使用！
                //window.location.href = "editor.html?uId="+data.uId;
                location.href="show.html?uId="+data.uId;
            }else{
                $("#msg").text("登录异常");
            }
        },
        error: function(){
            $("#msg").text("登录失败，请检查用户名或密码");
        }
    });
}