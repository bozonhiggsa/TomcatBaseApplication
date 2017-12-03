<%--
 JSP плюс JSTL плюс логирование плюс использование скриплета
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="application.base.User" %>
<% Logger logger=Logger.getLogger("jspEdit"); %>
<html>
<head>
    <title>Страница редактирования пользователя</title>
</head>
<body>
<% logger.info("Рендерится страница EditUser.jsp"); %>
<form action="${pageContext.servletContext.contextPath}/create?id=${userAttr.id}" method="POST">
    <input type="hidden" name="id" value="${userAttr.id}"/>
    <table>
        <tr>
            <td align="right"> Login : </td>
            <td>
                <input type="text" name="login" value="${userAttr.login}"/>
            </td>
        </tr>
    <tr>
        <td align="right"> Password : </td>
        <td>
           <%-- <input type="text" name="password" value="${userAttr.password}"/>--%>
            <input type="text" name="password" value="<%=((User)request.getAttribute("userAttr")).getPassword()%>"/> <%--использование скриплета, аналогично верхней строчке--%>
        </td>
    </tr>
    <tr>
        <td>
            <input type="submit" align="center" value="Submit"/>
        </td>
    </tr>
    </table>
</form>
</body>
</html>
