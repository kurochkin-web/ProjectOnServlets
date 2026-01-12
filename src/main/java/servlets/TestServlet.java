package servlets;

import entity.Test;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.CategoryService;
import services.TestService;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/secure/test")
public class TestServlet extends HttpServlet {

    private TestService testService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        testService = (TestService) config.getServletContext().getAttribute("testService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.valueOf(req.getParameter("id"));
        Test test = testService.getTestById(id);

        req.setAttribute("test", test);
        req.getRequestDispatcher("/secure/test.jsp").forward(req, resp);
    }
}
