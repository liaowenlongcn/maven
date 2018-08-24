<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>编辑</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/save" method="post" enctype="multipart/form-data">
    <input type="hidden" name="id" value="${user.id}">
    <table>
        <tr>
            <td>姓名：</td><td><input type="text" name="name" value="${user.name}"></td>
        </tr>
        <tr>
            <td>性别：</td><td><input type="text" name="sex" value="${user.sex}"></td>
        </tr>
        <tr>
            <td>年龄：</td><td><input type="text" name="age" value="${user.age}"></td>
        </tr>
        </tr>
        <tr>
            <td>头像：</td>
            <td>
                <c:if test="${user.img!=null}">
                    <img src="/images/${user.img}" width="100" height="100" >
                    <input type="hidden" name="img" value="${user.img}">
                    <br/>
                </c:if>
                <input type="file" name="imageFile"  >
            </td>
        </tr>
        <tr>
            <td colspan="4"><input type="submit" value="submit"></td>
        </tr>
    </table>

</form>

</body>
</html>
