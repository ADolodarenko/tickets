<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Билеты</title>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
    <header>
        <div class="header-image">
            <div class="header-text">
                <h2>Все билеты</h2>
            </div>
        </div>
    </header>
    <div>
        <table class="blueTable">
            <sec:authorize access="isAuthenticated()">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Дата</th>
                        <th>Цена</th>
                        <th>Клиент</th>
                        <th>*</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="ticket" items="${ticketsList}">
                        <tr>
                            <td>${ticket.id}</td>
                            <td>
                                <fmt:formatDate value="${ticket.date}" pattern="dd.MM.yyyy"/>
                            </td>
                            <td>${ticket.price}</td>
                            <td>${ticket.client.fullName}</td>
                            <td class="links">
                                <a href="ticketDelete/${ticket.id}">Удалить</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="7" align="center">
                            <c:url value="ticketAdd" var="add"/>
                            <div class="links">
                                <a href="/tickets">Главная</a>
                                <a href="${add}">Добавить</a>
                            </div>
                        </td>
                    </tr>
                </tfoot>
            </sec:authorize>
            <sec:authorize access="!isAuthenticated()">
                <tfoot>
                <tr>
                    <td colspan="2" align="center">
                        <div class="links">
                            <a href="<c:url value="/login" />">Войти</a>
                        </div>
                    </td>
                </tr>
                </tfoot>
            </sec:authorize>
        </table>
    </div>
</body>
</html>
