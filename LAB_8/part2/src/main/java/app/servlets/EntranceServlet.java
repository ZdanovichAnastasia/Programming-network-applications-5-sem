package app.servlets;

import app.DB.Users;
import app.entities.TestRes;

import javax.naming.NamingException;
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

public class EntranceServlet  extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("entrance.jsp");
        requestDispatcher.forward(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        if (req.getParameter("login")!=null){
            Users user = null;
            try {
                user = new Users();
            } catch (NamingException e) {
                e.printStackTrace();
            }
            user.setLog(req.getParameter("log"));
            user.setPass(req.getParameter("pass"));
            user.setRole("user");
            if(user.findUser().equals("user")){
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                HttpSession session = req.getSession();
                session.setAttribute("us", user);
                TestRes testRes = new TestRes();
                if(testRes.findRes(user.getLog()).equals("")){
                    response.sendRedirect("/test");
                }
                else if(testRes.findRes(user.getLog()).equals("0")){
                    out.println("Результаты теста находятся на проверке");
                    out.println("<button onclick=\"location.href='/'\">Вернуться в меню</button>");
                }
                else{
                    out.println("Ваша оценка: " + testRes.findRes(user.getLog()));
                    out.println("<button onclick=\"location.href='/test'\">Пройти тест еще раз</button>");
                    out.println("<button onclick=\"location.href='/'\">Вернуться в меню</button>");
                }
            }
            if(user.findUser().equals("admin")){
                HttpSession sessiona = req.getSession();
                Users users = (Users) sessiona.getAttribute("admin");
                try {
                    if(users == null) {
                        users = user;
                        sessiona.setAttribute("admin", users);

                    }
                }
                finally { }
                response.sendRedirect("/forAdmin");
            }
        }
    }
}
