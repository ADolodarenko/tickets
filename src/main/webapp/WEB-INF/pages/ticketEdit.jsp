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
                            <!--<input type="text" name="client" id="client" value="${ticket.client}">-->
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
                            <input type="number" name="price" id="price" value="${ticket.price}">
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
