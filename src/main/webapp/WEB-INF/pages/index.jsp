<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Клиенты и билеты</title>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
    <header>
        <div class="header-image">
            <div class="header-text">
                <h2>Клиенты и билеты</h2>
            </div>
        </div>
    </header>
    <div>
        <table class="blueTable">
            <tfoot>
                <sec:authorize access="isAuthenticated()">
                    <tr>
                        <td>
                            <div class="links">
                                <a href="clients">Клиенты</a>
                            </div>
                        </td>
                        <td>
                            <div class="links">
                                <a href="tickets">Билеты</a>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <div class="links">
                                <a href="<c:url value="/logout" />">Выйти</a>
                            </div>
                        </td>
                    </tr>
                </sec:authorize>
                <sec:authorize access="!isAuthenticated()">
                    <tr>
                        <td colspan="2" align="center">
                            <div class="links">
                                <a href="<c:url value="/login" />">Войти</a>
                            </div>
                        </td>
                    </tr>
                </sec:authorize>
            </tfoot>
        </table>
    </div>
</body>
</html>
