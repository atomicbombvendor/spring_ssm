<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>主页</title>
    <%--<script src="${pageContext.request.contextPath}/js/main.js"></script>--%>
    <%--<script src="<%=basePath%>/js/main.js"></script>--%>
    <script src="<c:url value="/js/main.js"></c:url>"></script>
    <!-- 以上三种方法都可以解决问题，但是要保证js目录不能在WEB-INF下面，因为无法方法-->
    <%--<link href="/res/css/main.css" rel="stylesheet">--%>
    </head>
<body>
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
            <td><input type="password" name="pwd" onKeyUp=pwStrength(this.value) onBlur=pwStrength(this.value)> </td>
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
</body>
</html>
