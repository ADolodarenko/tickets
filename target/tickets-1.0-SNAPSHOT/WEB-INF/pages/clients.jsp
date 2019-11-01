<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dolodarenko
  Date: 30.10.2019
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Клиенты</title>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
    <header>
        <div class="header-image">
            <div class="header-text">
                <h2>Все клиенты</h2>
            </div>
        </div>
    </header>
    <div>
        <table class="blueTable">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Логин</th>
                    <!--<th>Пароль</th>-->
                    <th>ФИО</th>
                    <th>Пол</th>
                    <th>*</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="client" items="${clientsList}">
                    <tr>
                        <td>${client.id}</td>
                        <td>${client.login}</td>
                        <!--<td>${client.password}</td>-->
                        <td>${client.fullName}</td>
                        <td>${client.sex}</td>
                        <td class="links">
                            <a href="clientEdit/${client.id}">Изменить</a>
                            <a href="clientDelete/${client.id}">Удалить</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="7" align="center">
                        <c:url value="clientAdd" var="add"/>
                        <div class="links">
                            <a href="/tickets">Главная</a>
                            <a href="${add}">Добавить</a>
                        </div>
                    </td>
                </tr>
            </tfoot>
        </table>
    </div>
</body>
</html>
