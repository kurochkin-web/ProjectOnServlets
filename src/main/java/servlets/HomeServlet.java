package servlets;

import entity.Test;
import entity.User;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.CategoryService;
import services.TestService;
import services.UserService;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/secure/home")
public class HomeServlet extends HttpServlet {

    private CategoryService categoryService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        categoryService = (CategoryService) config.getServletContext().getAttribute("categoryService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.getRequestDispatcher("/secure/home.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
