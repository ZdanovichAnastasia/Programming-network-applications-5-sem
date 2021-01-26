<%--
  Created by IntelliJ IDEA.
  User: Mi
  Date: 27.11.2020
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <div>
        <div>
            <div>
                <h2>Properties:</h2>
            </div>
            <div>
                <form method="post">
                    <label>Введите логин:
                        <input type="text" name="log"><br />
                    </label>
                    <label>Ввелите пароль:
                        <input type="password" name="pass"><br />
                    </label>
                    <input type="submit" name="login" value="Войти в систему">
                </form>
            </div>
        </div>

        <div>
            <button onclick="location.href='/'">Выйти из системы</button>
        </div>
    </div>
</head>
<body>

</body>
</html>
