<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Sasha
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
            <form method="post">
                <label>Select the type of the watch:
                    <select name="type">
                        <option>quartz</option>
                        <option>mechanical</option>
                    </select><br />
                </label>
                <input type="submit" name="enter1" value="Display brands of the specified watch type">
                <%
                    ArrayList<String> listBrand = (ArrayList<String>) request.getAttribute("listBrand");
                    if(listBrand != null && !listBrand.isEmpty()){
                        out.println("<ui>");
                        for(String brand: listBrand){
                            out.println("<li>" + brand + "</li>");
                        }
                        out.println("</ui>");
                    }else out.println("<p>There are no results yet!</p>");
                %>
                <label>Enter the price:
                    <input type="text" name="price"><br/>
                </label>
                <input type="submit" name="enter2" value="Display information about mechanical watches whose price does not exceed the specified price">
                <%
                    ArrayList<String[]> listInfo = (ArrayList<String[]>) request.getAttribute("listInfo");
                    if(listInfo != null && !listInfo.isEmpty()){
                        out.println("<ui>");
                        out.println("size " + listInfo.size());
                        for(String[] info: listInfo){
                            out.println("<li> Brand: " + info[1] + " &ensp;&ensp;Type: " + info[2] + " &ensp;&ensp;Price: " + info[3]
                                    + " &ensp;&ensp;Amount: " + info[4] + " &ensp;&ensp;Producer: " + info[5] + "</li>");
                        }
                        out.println("</ui>");
                    }else out.println("<p>There are no results yet!</p>");
                %>
                <input type="submit" name="enter4" value="Display manufacturers whose total hours in the store do not exceed the specified amount.">
                <%
                    ArrayList<String> listProducer = (ArrayList<String>) request.getAttribute("listProducer");
                    if(listProducer != null && !listProducer.isEmpty()){
                        out.println("<ui>");
                        for(String pr: listProducer){
                            out.println("<li>" + pr + "</li>");
                        }
                        out.println("</ui>");
                    }else out.println("<p>There are no results yet!</p>");
                %>
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
                <input type="submit" name="enter3" value="Display brands of watches made in the specified country">
                <%
                    ArrayList<String> listBrandsC = (ArrayList<String>) request.getAttribute("listBrandC");
                    if(listBrandsC != null && !listBrandsC.isEmpty()){
                        out.println("<ui>");
                        for(String brand: listBrandsC){
                            out.println("<li>" + brand  + "</li>");
                        }
                        out.println("</ui>");
                    }else out.println("<p>There are no results yet!</p>");
                %>
            </form>
        </div>
    </div>

    <div>
        <button onclick="location.href='/'">Back to main</button>
    </div>
</div>
</body>
</html>
