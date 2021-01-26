<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Mi
  Date: 29.11.2020
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <div>
        <div>
            <form method="post">
            <%
                ArrayList<String[]> resList = (ArrayList<String[]>) request.getAttribute("results");
                if(resList != null && !resList.isEmpty()){
                    int k = 0;
                    for(String[] res: resList){
                        out.println("Выполнил: " + res[0]);
                        for(int i = 1; i<=8; i++){
                            out.println(i + ") "+res[i]);
                        }
                        out.print("<br/><label>Балл:\n" +
                                "                        <input type=\"text\" name=\"b"+k+"\"><br />\n" +
                                "                    </label>");
                        out.print("<br/> <input type=\"submit\" name=\"pass"+k+"\" value=\"Выставить оценку\"><br/>");
                        out.println("_________________________________________________________________________________<br/>");
                        k++;
                    }
                }else out.println("<p>Нет тестов для проверки!</p>");

            %><br/>
            </form>
        </div>
    </div>

    <div>
        <button onclick="location.href='/'">Выйти из системы</button>
    </div>
</div>
</body>
</html>
