<%--
 Демонстрация доступа к полям бина на странице JSP. Страница запускается независимо по URI из адресной строки
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="application.base.UserBean" %>
<% Logger logger=Logger.getLogger("jspBeanView"); %>
<html>
<head>
    <title>Пример доступа к бину</title>
</head>
<body>
<% logger.info("Рендерится страница BeanView.jsp"); %>
<%--<% request.setAttribute("Attr", new UserBean()); %>--%> <%--альтернативная установка аттрибута при помощи скриплета--%>
<jsp:useBean id="Attr" scope="page" class="application.base.UserBean"></jsp:useBean>
    <jsp:setProperty name="Attr" property="name" value="Jack" />
<table border="1">
    <tr>
        <td>${Attr.age}</td>
        <td>${Attr.name}</td>
        <td><%= request.getSession(false).getAttribute("counter")%></td>
    </tr>
</table>
</body>
</html>
