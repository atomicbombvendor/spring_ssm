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
    <link rel="stylesheet" href="../css/timeline.css">
    <script src="../js/index.js"></script>
</head>
<body>
<%@ include file="../navigation/navigation.jsp" %>
<h2 class="top_title">${Label}</h2>
<section id="cd-timeline" class="cd-container">
<c:if test="${!empty blogList}">
    <c:forEach var="Blog" items="${blogList}">
    <div class="cd-timeline-block">
        <div class="cd-timeline-img cd-picture">
            <img src="/resource/img/cd-icon-picture.svg" alt="Picture">
        </div>
        <div class="cd-timeline-content">
            <h2>${Blog.title}</h2>
            <p>${Blog.content.substring(0, Blog.content.indexOf("</p>")+4)}</p>
            <a href="showBlogDetail?tid=${Blog.tid}">阅读全文>></a>
            <span class="cd-date">${Blog.updateTime.toString().substring(0,10)}</span>
        </div>
    </div>
    </c:forEach>
</c:if>
</section>
<span style="font-size:16px"><p id="back-to-top"><a href="#top"><span>返回顶部</span></a></p></span>
</body>
</html>