<%--
  JSP плюс JSTL плюс логирование
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.apache.log4j.Logger" %>
<% Logger logger=Logger.getLogger("jspErrorLoginPassword"); %>
<html>
<head>
    <title>Страница ошибки</title>
</head>
<body>
<% logger.info("Рендерится страница ошибки - обнаружены совпадения полей с уже существующими"); %>
<div align="left"><h3> Ошибка!!! Пользователь с таким login и/или password уже существует </h3></div>
<a href="${pageContext.servletContext.contextPath}/views/CreateUser.jsp">Добавить пользователя</a>
<table border="1">
    <tr>
        <td>Login</td>
        <td>Password</td>
        <td>Действия</td>
    </tr>
    <c:forEach items="${usersAttr}" var="user">
        <tr valign="top">
            <td> ${user.login} </td>
            <td> ${user.password} </td>
            <td>
                <a href="${pageContext.servletContext.contextPath}/edit?id=${user.id}">Редактировать</a>
                <a href="${pageContext.servletContext.contextPath}/delete?id=${user.id}">Удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
