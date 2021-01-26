package database.servlets;

import database.Producer;
import database.Watch;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddWatchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Producer producer = new Producer();
        ArrayList<String> listPr = producer.selectNames();
        req.setAttribute("listPr", listPr);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("AddWatch.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("addW")!=null){
            Watch watch = new Watch();
            Producer producer = new Producer();
            producer.setName(req.getParameter("idPr"));
            watch.setBrand(req.getParameter("brand"));
            watch.setType(req.getParameter("type"));
            watch.setPrice(req.getParameter("price"));
            watch.setAmount(req.getParameter("num"));
            watch.setIdProducer(producer.find());
            //watch.setIdProducer(req.getParameter("idPr"));
            if(watch.find().equals("") && String.valueOf(watch.getAmount())!="" && String.valueOf(watch.getIdProducer())!="" && String.valueOf(watch.getPrice())!="" && watch.getBrand()!="" && watch.getType()!=""){
                watch.insert();
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("SuccessAdd.jsp");
                requestDispatcher.forward(req, resp);
            }
            else{
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("ErrorAddW.jsp");
                requestDispatcher.forward(req, resp);
            }

        }
    }
}