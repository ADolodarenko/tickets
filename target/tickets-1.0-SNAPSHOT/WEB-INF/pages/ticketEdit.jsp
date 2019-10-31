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
    <title>Добавление билета</title>
</head>
<body>
    <header>
        <div class="header-image">
            <div class="header-text">
                <h2>Новый билет</h2>
            </div>
        </div>
    </header>
    <div>
        <c:url value="/ticketAdd" var="var"/>

        <form action="${var}" method="post">
            <table class="blueTable">
                <thead>
                    <tr>
                        <th>Параметр</th>
                        <th>Значение</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Клиент</td>
                        <td>
                            <select name="client" id="client">
                                <c:forEach var="client" items="${clientsList}">
                                    <option value="${client}">${client.login}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Дата</td>
                        <td>
                            <input type="date" name="date" id="date" value="${ticket.date}">
                        </td>
                    </tr>
                    <tr>
                        <td>Цена</td>
                        <td>
                            <input type="number" step="0.01" min="0.01" name="price" id="price" value="${ticket.price}">
                        </td>
                    </tr>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Сохранить"><a href="/tickets/tickets"><input type="button" value="Отмена"></a>
                        </td>
                    </tr>
                </tfoot>
            </table>
        </form>
    </div>
</body>
</html>
