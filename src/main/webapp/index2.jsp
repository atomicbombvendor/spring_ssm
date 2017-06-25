<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>主页</title>
    <!-- 引用bootstrap-->
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
    <script src="<c:url value="/js/main.js"></c:url>"></script>
    </head>
<body>
<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="bootstrap/js/jquery-3.2.1.min.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="bootstrap/js/bootstrap.min.js"></script>
<h2>Hello World!</h2>
<a href="user/showUser">/user/showUser</a>
<!-- href不能接 /,如果加了，访问的request则不会带有spring_ssm-->
<a href="student/showStudent">student/showStudent</a>
<form:form action="user/newUser" method="post">
    <table width="250" border="0" cellpadding=2" bordercolor="#eeeeee" style='display:inline'>
        <tr>
            <td>Name:</td>
            <td><input name="userName"/></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="email" name="email"></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="pwd" onKeyUp=pwStrength(this.value) onBlur=pwStrength(this.value)></td>
        </tr>
        <tr align="center">
            <td width="40%" align="right">密码强度:</td>
            <td width="20%" id="strength_L" bgcolor="#eeeeee">弱</td>
            <td width="20%" id="strength_M" bgcolor="#eeeeee">中</td>
            <td width="20%" id="strength_H" bgcolor="#eeeeee">强</td>
        </tr>
    </table>
    <input type="submit" value="Submit">
</form:form>
<a href="test.jsp" value="test">test</a>
</body>
</html>
