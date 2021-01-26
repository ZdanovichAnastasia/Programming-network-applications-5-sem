package database.servlets;

import database.ConnectionDB;
import database.Producer;
import database.Watch;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ShowServlet  extends HttpServlet {
    private ArrayList<String> LBrands;
    private ArrayList<String[]> LInfo;
    private ArrayList<String> LBrandsC;
    private ArrayList<String> LProducer;
    private ConnectionDB connectionDB;

    public ArrayList<String> showLBrands(String type){
        connectionDB = ConnectionDB.getInstance();
        String str = "SELECT * From watch Where type = '" + type + "'";
        ArrayList<String[]> result = connectionDB.getArrayResult(str);
        LBrands = new ArrayList<>();
        for (String[] items: result){
            LBrands.add(items[1]);
        }
        return LBrands;
    }
    public ArrayList<String[]> showLInfo(double price){
        connectionDB = ConnectionDB.getInstance();
        String str = "SELECT * From watch Where type = 'mechanical'";
        ArrayList<String[]> result = connectionDB.getArrayResult(str);
        LInfo = new ArrayList<>();
        Producer producer = new Producer();
        for(String[] items: result){
            if(Double.parseDouble(items[3]) <= price){
                String name = producer.find(Integer.parseInt(items[5]));
                items[5] = name;
                LInfo.add(items);
            }
        }
        return LInfo;
    }
    public ArrayList<String> showLBrandsC(String country){
        connectionDB = ConnectionDB.getInstance();
        String str = "select brand from watch w3 JOIN producer p2 on p2.idproducer = w3.producerid where country = '"+country+"'";
        ArrayList<String[]> result = connectionDB.getArrayResult(str);
        LBrandsC = new ArrayList<>();
        for (String[] items: result){
            LBrandsC.add(items[0]);
        }
        return LBrandsC;
    }
    public ArrayList<String> showLProducer(double price){
        connectionDB = ConnectionDB.getInstance();
        String str = "select name, sum(price) from watch w3 JOIN producer p2 on p2.idproducer = w3.producerid ";
        ArrayList<String[]> result = connectionDB.getArrayResult(str);
        LProducer = new ArrayList<>();
        for(String[] items: result){
            if(Double.parseDouble(items[1]) <= price){
                LProducer.add(items[0]);
            }
        }
        return LProducer;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listBrand", LBrands);
        req.setAttribute("listInfo", LInfo);
        req.setAttribute("listBrandC", LBrandsC);
        req.setAttribute("listProducer", LProducer);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("show.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("enter1")!=null){
            LBrands = showLBrands(req.getParameter("type"));
        }
        if (req.getParameter("enter2")!=null) {
            LInfo = showLInfo(Double.parseDouble(req.getParameter("price")));
        }
        if (req.getParameter("enter3")!=null){
            LBrandsC = showLBrandsC(req.getParameter("country"));
        }
        if (req.getParameter("enter4")!=null){
            LProducer = showLProducer(Double.parseDouble(req.getParameter("price")));
        }
    }
}