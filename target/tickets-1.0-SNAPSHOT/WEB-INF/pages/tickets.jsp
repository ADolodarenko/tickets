<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dolodarenko
  Date: 30.10.2019
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Билеты</title>
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
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Дата</th>
                    <th>Цена</th>
                    <th>Клиент</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="ticket" items="${ticketsList}">
                    <tr>
                        <td>${ticket.id}</td>
                        <td>${ticket.date}</td>
                        <td>${ticket.price}</td>
                        <td>${ticket.client}</td>
                        <td>
                            <a href="ticketDelete/${ticket.id}">delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="7" align="center">
                        <c:url value="ticketAdd" var="add"/>
                        <a href="${add}">Добавить билет</a>
                    </td>
                </tr>
            </tfoot>
        </table>
    </div>
</body>
</html>
