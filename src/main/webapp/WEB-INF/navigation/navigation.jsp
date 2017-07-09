<%@ page language="java" import="java.*,java.util.*"
         contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 通过这种方式来引用子页面-->
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
                <a class="navbar-brand" href="showBlog">Bomb</a>
            </div>
            <div class="collapse navbar-collapse" id="example-navbar-collapse">
                <ul class="nav navbar-nav">
                    <li><a href="labelBlog?labelName=Java">Java</a></li>
                    <li><a href="labelBlog?labelName=测试">测试</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            Nothing <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Nothing</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Nothing</a></li>
                        </ul>
                    </li>
                </ul>
                <form class="navbar-form navbar-right" role="search">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-default btn-sm">搜索</button>
                </form>
            </div>
            <div>
            </div>
        </div>
    </nav>
</header>


