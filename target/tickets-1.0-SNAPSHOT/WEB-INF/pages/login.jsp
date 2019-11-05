<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <c:url value="/j_spring_security_check" var="loginUrl" />
        <form action="${loginUrl}" method="post">
            <table class="blueTable">
                <tbody>
                    <tr>
                        <td>Логин</td>
                        <td>
                            <input type="text" name="j_username" required autofocus value="">
                        </td>
                    </tr>
                    <tr>
                        <td>Пароль</td>
                        <td>
                            <input type="password" name="j_password" required autofocus value="">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <button type="submit">Войти</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </div>
</body>
</html>
