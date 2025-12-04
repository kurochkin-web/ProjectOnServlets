package servlets;

import entity.Test;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.TestService;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/secure/home")
public class HomeServlet extends HttpServlet {

    private TestService testService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("user");
        List<Test> listTest = testService.findListTestsByID(user.getTestsId());
        req.getRequestDispatcher("/secure/home.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
