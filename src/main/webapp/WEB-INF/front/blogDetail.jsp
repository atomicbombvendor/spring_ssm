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
<header id="top">
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse"
                        data-target="#example-navbar-collapse">
                    <span class="sr-only">切换导航</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Bomb</a>
            </div>
            <div class="collapse navbar-collapse" id="example-navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">iOS</a></li>
                    <li><a href="#">SVN</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            Java <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#">jmeter</a></li>
                            <li><a href="#">EJB</a></li>
                            <li><a href="#">Jasper Report</a></li>
                            <li class="divider"></li>
                            <li><a href="#">分离的链接</a></li>
                            <li class="divider"></li>
                            <li><a href="#">另一个分离的链接</a></li>
                        </ul>
                    </li>
                </ul>
                <form class="navbar-form navbar-right" role="search">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-default btn-sm">提交按钮</button>
                </form>
            </div>
            <div>
            </div>
        </div>
    </nav>
</header>
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
