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
    <link rel="stylesheet" href="../css/index.css">
    <script src="../js/index.js"></script>
</head>
<body>
<%@ include file="../navigation/navigation.jsp" %>
<table>
<c:if test="${!empty blogList}">
    <c:forEach var="Blog" items="${blogList}">
        <tr>
            <td>
                <h2 class="blogTitle"><a href="showBlogDetail?tid=${Blog.tid}">${Blog.title}</a></h2>
                <em>${Blog.content.substring(0, Blog.content.indexOf("</p>")+4)}</em>
                <div><a href="showBlogDetail?tid=${Blog.tid}">阅读全文>></a> </div>
                <hr/>
            </td>
        </tr>
    </c:forEach>
</c:if>
<c:if test="${empty blogList}">
    <tr>
        <td>
            <p>no blog</p>
        </td>
    </tr>
</c:if>
</table>
</body>
</html>
