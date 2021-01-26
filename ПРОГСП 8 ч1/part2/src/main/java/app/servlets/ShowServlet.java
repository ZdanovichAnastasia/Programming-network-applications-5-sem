package app.servlets;

import app.entities.Result;
import app.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Model model = Model.getInstance();
        List<String> results = model.list();
        List<String> size = model.size();

        req.setAttribute("funResults", results);
        req.setAttribute("size", size);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("show.jsp");
        requestDispatcher.forward(req, resp);
    }
}
