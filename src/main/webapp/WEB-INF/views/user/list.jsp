 <%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
用户列表
<table width="100%" border="1">
    <tr>
        <td>姓名</td>
        <td>性别</td>
        <td>年龄</td>
    </tr>
    <c:forEach items="${list}" var="item">
        <tr>
            <td>${item.name}</td>
            <td>${item.sex}</td>
            <td>${item.age}</td>
            <td><a href="${pageContext.request.contextPath}/user/edit?id=${item.id}">修改</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
