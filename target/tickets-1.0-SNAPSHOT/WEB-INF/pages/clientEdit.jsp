<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dolodarenko
  Date: 30.10.2019
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:if test="${empty client.id}">
        <title>Добавление клиента</title>
    </c:if>
    <c:if test="${!empty client.id}">
        <title>Редактирование клиента</title>
    </c:if>
</head>
<body>
    <header>
        <div class="header-image">
            <div class="header-text">
                <c:if test="${empty client.id}">
                    <h2>Новый клиент</h2>
                </c:if>
                <c:if test="${!empty client.id}">
                    <h2>Клиент ${client.id}</h2>
                </c:if>
            </div>
        </div>
    </header>
    <div>
        <c:if test="${empty client.id}">
            <c:url value="/clientAdd" var="var"/>
        </c:if>
        <c:if test="${!empty client.id}">
            <c:url value="/clientEdit" var="var"/>
        </c:if>

        <form action="${var}" method="post">
            <table class="blueTable">
                <thead>
                    <tr>
                        <th>Параметр</th>
                        <th>Значение</th>
                    </tr>
                </thead>
                <tbody>
                    <c:if test="${!empty client.id}">
                        <tr>
                            <td>Id</td>
                            <td>${client.id}</td>
                        </tr>
                        <input type="hidden" name="id" value="${client.id}">
                    </c:if>
                    <tr>
                        <td>Логин</td>
                        <td>
                            <input type="text" name="login" id="login" value="${client.login}">
                        </td>
                    </tr>
                    <tr>
                        <td>Пароль</td>
                        <td>
                            <input type="password" name="password" id="password" value="${client.password}">
                        </td>
                    </tr>
                    <tr>
                        <td>ФИО</td>
                        <td>
                            <input type="text" name="fullName" id="fullName" value="${client.fullName}">
                        </td>
                    </tr>
                    <tr>
                        <td>Пол</td>
                        <td>
                            <input type="checkbox" name="sex" id="sex" value="${client.sex}">
                        </td>
                    </tr>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Сохранить"><a href="/tickets"><input type="button" value="Отмена"></a>
                        </td>
                    </tr>
                </tfoot>
            </table>
        </form>
    </div>
</body>
</html>
