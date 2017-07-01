<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8" http-equiv="X-UA-Compatible" content="IE=Edge">
    <title>主页</title>
    <!-- 引用bootstrap-->
    <!-- 引用css文件-->
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
    <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
    <script src="../bootstrap/js/jquery-3.2.1.min.js"></script>
    <!-- 包括所有已编译的插件 -->
    <script src="../bootstrap/js/bootstrap.min.js"></script>
    <script src="../js/index.js"></script>
    <link rel="stylesheet" href="../css/index.css">
</head>
<body>
<%--<%@ include file="../navigation/navigation.html"%>--%>
<div class="navigation"></div>
<div class="row">
<div class="col-md-6 col-md-offset-3">
    <hr/>
    <c:if test="${!empty blogList}">
        <c:forEach var="Blog" items="${blogList}">
            <h2 class="text-center"><a href="showBlogDetail?tid=${Blog.tid}">${Blog.title}</a></h2>
            <p>${Blog.content}</p>
        </c:forEach>
    </c:if>
   <c:if test="${!empty blogList}">
    <p>no blog</p>
  </c:if>
</div>
</div>
<span style="font-size:16px"><p id="back-to-top"><a href="#top"><span>返回顶部</span></a></p></span>
</body>
</html>
//wwdsjwhkdsjwjdjfkwjeidjskljwiwikwkwidkljfwiwjlqosdkljsdifwiiwiweiuruewlkwjksdkdjliwiwlsdkwpapdklfjasiwikwkwjeiwwoiejwljfdlsjfdlsf
