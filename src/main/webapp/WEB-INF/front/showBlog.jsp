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
<a href="../../test.html" >ddd</a>
<div class="navigation"></div>
<div class="row">
    <div class="col-md-6 col-md-offset-3">
        <hr/>
        <table id="blogTable">
            <thead>
            <tr>
                <th>content</th>
            </tr>
            </thead>
            <c:if test="${!empty blogList}">
                <c:forEach var="Blog" items="${blogList}">
                    <tr>
                        <td>
                            <h2 class="text-center"><a href="showBlogDetail?tid=${Blog.tid}">${Blog.title}</a></h2>
                            <p>${Blog.content}</p>
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
    </div>
    <div class="col-md-6 col-md-offset-3">
        <ul class="pager">
            <li class="previous"><a href="#" onclick="prePage()">&larr;
                Older</a></li>
            <li>共有 <span id="spanTotalInfo">${blogList.size()}</span> 条博客</li>
            <li>当前第 <span id="spanPageNum" value="1">1</span> 页</li>
            <li>共 <span id="spanTotalPage">${pageNum}</span>页</li>
            <li class="next"><a onclick="test()">Newer &rarr;</a></li>
        </ul>
    </div>
</div>
<span style="font-size:16px"><p id="back-to-top"><a href="#top"><span>返回顶部</span></a></p></span>
<script src="../js/page.js"></script>
</body>
</html>
