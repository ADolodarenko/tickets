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
    <title>${empty client.id ? "Добавление клиента" : "Редактирование клиента"}</title>
</head>
<body>
    <header>
        <div class="header-image">
            <div class="header-text">
                <c:choose>
                    <c:when test="${empty client.id}">
                        <h2>Новый клиент</h2>
                    </c:when>
                    <c:otherwise>
                        <h2>Клиент ${client.id}</h2>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </header>
    <div>
        <c:choose>
            <c:when test="${empty client.id}">
                <c:url value="/clientAdd" var="var"/>
            </c:when>
            <c:otherwise>
                <c:url value="/clientEdit" var="var"/>
            </c:otherwise>
        </c:choose>

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
                            <select name="sex" id="sex">
                                <c:choose>
                                    <c:when test="${empty client.id}">
                                        <option value="true" selected>Мужской</option>
                                        <option value="false">Женский</option>
                                    </c:when>
                                    <c:otherwise>
                                        <c:choose>
                                            <c:when test="${client.sex==true}">
                                                <option value="true" selected>Мужской</option>
                                                <option value="false">Женский</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="true">Мужской</option>
                                                <option value="false" selected>Женский</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:otherwise>
                                </c:choose>
                            </select>
                        </td>
                    </tr>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Сохранить"><a href="/tickets/clients"><input type="button" value="Отмена"></a>
                        </td>
                    </tr>
                </tfoot>
            </table>
        </form>
    </div>
</body>
</html>
