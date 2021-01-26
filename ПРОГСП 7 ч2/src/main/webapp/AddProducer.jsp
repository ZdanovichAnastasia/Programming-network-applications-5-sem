<%--
  Created by IntelliJ IDEA.
  User: Mi
  Date: 28.11.2020
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Producer</title>
</head>
<body>
<div>
    <div>
        <h2>Properties:</h2>
    </div>
    <div>
        <form method="post">
            <label>Enter producer name:
                <input type="text" name="name"><br/>
            </label>
            <label>Select the country of the producer:
                <select name="country">
                    <option>Gernamy</option>
                    <option>USA</option>
                    <option>Switzerland</option>
                    <option>Japan</option>
                    <option>Russia</option>
                    <option>France</option>
                    <option>South Korea</option>
                    <option>Italy</option>
                    <option>UK</option>
                </select><br />
            </label>
            <input type="submit" name="addPr" value="Add producer">
        </form>
    </div>
    <div>
        <button onclick="location.href='/'">Back to main</button>
    </div>
</div>
</body>
</html>