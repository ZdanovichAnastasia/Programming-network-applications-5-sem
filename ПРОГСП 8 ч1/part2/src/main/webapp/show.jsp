<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Sveta
  Date: 09.11.2020
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Users list</title>
</head>
<body>
<div>
    <div>
        <div>
            <div>
                <h2>Results</h2>
            </div>
            <%
                List<String> resList = (List<String>) request.getAttribute("funResults");
                List<Integer> size = (List<Integer>) request.getAttribute("size");

                if (resList != null && !resList.isEmpty()) {
                    int k = 0;
                    for(String str: resList){
                        String [] strq = str.split(" /");
                        for(int i =0; i< strq.length; i++) {
                            out.println("<div style='font-size:" + size.get(k) + "px; color: #A8AFA6'>" + strq[i] + "</div>");
                        }
                        k++;
                    }
                } else out.println("<p>There are no results yet!</p>");
            %><br/>
        </div>
    </div>

    <div>
        <button onclick="location.href='/part2_war/'">Back to main</button>
    </div>
</div>
</body>
</html>
