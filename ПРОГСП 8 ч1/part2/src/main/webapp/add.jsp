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
                <label>Enter size:
                    <input type="number" name="size"><br />
                </label>
                <label>Enter amount:
                    <input type="number" name="amount"><br />
                </label>
                <button type="submit">Submit</button>
            </form>
        </div>
    </div>

    <div>
        <button onclick="location.href='/part2_war/'">Back to main</button>
    </div>
</div>
</body>
</html>