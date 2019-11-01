<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dolodarenko
  Date: 30.10.2019
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            </tfoot>
        </table>
    </div>
</body>
</html>
