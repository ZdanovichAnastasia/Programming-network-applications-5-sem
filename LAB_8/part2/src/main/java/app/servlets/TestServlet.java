package app.servlets;

import app.DB.Users;
import app.entities.TestRes;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("test.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if (req.getParameter("send")!=null){
            HttpSession session = req.getSession();
            Users users = (Users) session.getAttribute("us");
            try {
                if(users != null){
                    String [] res = new String[9];
                    res[0] = users.getLog();
                    for(int i = 1; i<=8; i++){
                        String[] parameter = req.getParameterValues("q" + i);
                        res[i] = parameter[0];
                    }
                    TestRes testRes = new TestRes();
                    testRes.setRes(res);
                }
            }
            finally { }

        }
    }
}
