<%--
  Created by IntelliJ IDEA.
  User: Sveta
  Date: 09.11.2020
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new user</title>
</head>
<body>
<div>
    <div>
        <div>
            <h2>Properties:</h2>
        </div>
        <div>
            <form method="post">
                <label>Название:
                    <input type="text" name="namePr"><br />
                </label>
                <label>Страна:
                    <select name="funSelect">
                        <option>Германия</option>
                        <option>США</option>
                        <option>Швейцария</option>
                        <option>Япония</option>
                        <option>Россия</option>
                        <option>Франция</option>
                        <option>Южная Корея</option>
                        <option>Италия</option>
                        <option>Дания</option>
                        <option>Великобритания</option>
                    </select><br />
                </label>
                <button type="submit">Submit</button>
            </form>
        </div>
    </div>

    <div>
        <button onclick="location.href='/'">Back to main</button>
    </div>
</div>
</body>
</html>