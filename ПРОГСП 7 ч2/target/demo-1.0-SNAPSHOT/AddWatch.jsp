<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Mi
  Date: 28.11.2020
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add watch</title>
</head>
<body>
<div>
    <div>
        <h2>Properties:</h2>
    </div>
    <div>
        <form method="post">
            <label>Enter the brand of thе watch:
                <input type="text" name="brand"><br/>
            </label>
            <label>Select the type of the watch:
                <select name="type">
                    <option>quartz</option>
                    <option>mechanical</option>
                </select><br />
            </label>
            <label>Enter the price:
                <input type="text" name="price"><br/>
            </label>
            <label>Enter the number:
                <input type="number" name="num"><br/>
            </label>
            <%
                ArrayList<String> listPr = (ArrayList<String>) request.getAttribute("listPr");
                out.println("size ");
                out.println("<label>Select the producer: <select name=\"idPr\">");
                if (listPr != null && !listPr.isEmpty()) {
                    //out.println("<label>Select the producer: <select name=\"idPr\">");
                    for (String s : listPr) {
                        out.println("<option>"+s+"</option>");

                    }
                    //out.println("</select><br />\n" +"</label>");
                }
                out.println("</select><br />\n" +
                        "</label>");
            %><br/>
            <input type="submit" name="addW" value="Add watch">
        </form>
    </div>
    <div>
        <button onclick="location.href='/'">Back to main</button>
    </div>
</div>
</body>
</html>
