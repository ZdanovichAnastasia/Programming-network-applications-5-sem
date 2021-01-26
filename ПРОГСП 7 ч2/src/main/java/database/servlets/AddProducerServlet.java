package database.servlets;

import database.Producer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddProducerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("AddProducer.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("addPr")!=null){
            Producer producer = new Producer();
            producer.setName(req.getParameter("name"));
            producer.setCountry(req.getParameter("country"));
            if(producer.find().equals("") && producer.getCountry()!="" && producer.getName()!=""){
                producer.insert();
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("SuccessAdd.jsp");
                requestDispatcher.forward(req, resp);
            }
            else{
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("ErrorAddPr.jsp");
                requestDispatcher.forward(req, resp);
            }

        }
    }
}
