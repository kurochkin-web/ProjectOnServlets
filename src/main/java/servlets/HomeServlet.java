package servlets;

import entity.Category;
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
    private TestService testService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        categoryService = (CategoryService) config.getServletContext().getAttribute("categoryService");
        testService = (TestService) config.getServletContext().getAttribute("testService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Category> categories = categoryService.getAllCategories();
        List<Test> tests = testService.getAllTests();
        req.setAttribute("categories", categories);
        req.setAttribute("tests", tests);
        req.getRequestDispatcher("/secure/home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
