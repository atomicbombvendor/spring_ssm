<%--
  Created by IntelliJ IDEA.
  User: ZZ
  Date: 2017/5/4
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Student info list ss</title>
</head>
<body>
<table>
    <tr>
        <th>NAME</th>
        <th>SEX</th>
        <th>删除</th>
    </tr>
    <c:if test="${!empty studentList}">
        <c:forEach var="student" items="${studentList}">
            <tr>
                <td>${student.name}</td>
                <td>${student.sex}</td>
                <td><a href="deleteStudent?id=${student.sid}" onclick="return confirm('确定吗？');" id="reCheck">删除</a> </td>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>
