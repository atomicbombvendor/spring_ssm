<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8" http-equiv="X-UA-Compatible" content="IE=Edge">
    <title>${resultMap['title'].toString()}</title>
    <!-- 引用bootstrap-->
    <!-- 引用css文件-->
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
    <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
    <script src="../bootstrap/js/jquery-3.2.1.min.js"></script>
    <!-- 包括所有已编译的插件 -->
    <script src="../bootstrap/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="../css/index.css">
    <script src="<c:url value="/js/index.js"></c:url>"></script>
</head>

<body>
<%@ include file="../navigation/navigation.jsp"%>
<div class="row">
    <div class="col-md-6 col-md-offset-3">
        <c:if test="${!empty resultMap}">
        <h2 class="text-center">${resultMap['title'].toString()}</h2>
            <p class="text-center">
                <em><span class="post-meta-item-text">发表于 </span>
                    <time title="创建于" itemprop="dateCreated datePublished" datetime="${resultMap['create_time']}">${resultMap['create_time'].toString().substring(0,10)}</time> | </em>
                <em><span class="post-meta-item-text">更新于 </span>
                    <time title="最后修改" itemprop="dateCreated datePublished" datetime="${resultMap['alter_time']}">${resultMap['alter_time'].toString().substring(0,10)}</time> | </em>
                <em><span class="post-meta-item-text">分类 </span>
                    <c:forEach var="value" items="${resultMap['label'].toString().split(',')}">
                    <a href="${value}">${value}</a>
                   </c:forEach></em>
                <em> <span> | 添加者 </span><span>${resultMap['user_name']}</span></em>
            </p>
            <p class="text-center"><em>${resultMap['decoration']}</em></p>
        <article>${resultMap['content'].toString()}</article>
        </c:if>
        <c:if test="${empty resultMap}">
            <p>NULL</p>
        </c:if>
    </div>
</div>
</body>
</html>
