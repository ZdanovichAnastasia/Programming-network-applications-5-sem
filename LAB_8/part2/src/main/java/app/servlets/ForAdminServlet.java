package app.servlets;

import app.DB.Users;
import app.entities.TestRes;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ForAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        TestRes testRes = new TestRes();
        req.setAttribute("results", testRes.getRes());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("forAdmin.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        TestRes testRes = new TestRes();
        ArrayList<String[]> resList = testRes.getRes();
        String[] pass = new String[2];
        for(int i = 0; i< resList.size(); i++){
            if(req.getParameter("b"+i)!=null && req.getParameter("pass"+i)!=null){
                pass[0] = resList.get(i)[0];
                pass[1] = req.getParameter("b"+i);
                testRes.setPass(pass);
            }
        }
    }
}