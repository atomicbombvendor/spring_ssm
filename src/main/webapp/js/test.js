/**
 * Created by eli9 on 7/27/2017.
 */
function func() {
    $.ajax({
        type : "POST",  //提交方式
        url : "admin/test",//路径
        dataType: "json",
        data : {
            "content" : "content test"
        },//数据，这里使用的是Json格式进行传输
        async: false,
        success : function(data) {//返回数据根据结果进行相应的处理
            if ( data!=null ) {
                alert("success");
                $.each(data, function (index, element) {
                    alert(element.a);
                    alert(element.b);
                    alert(element.c);
                    $("#tipMsg").text(element.a+element.b+element.c);
                })
            } else {
                $("#tipMsg").text("获取数据失败");
            }
        },
        error: function() {
            alert("error");
        }
    });
}