package servlets;

import entity.User;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.codec.Utf8;
import services.UserService;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private UserService userService;
    private static final Logger log = Logger.getLogger(LoginServlet.class.getName());

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userService = (UserService) config.getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        Optional<User> optionalUser = userService.findUserByCredentials(login, password);

        if (optionalUser.isPresent()){
            log.info("Юзер найден");
            req.getSession().setAttribute("user", optionalUser.get());
            resp.sendRedirect(req.getContextPath() + "/secure/home");
        } else {
            log.info("Юзер не найден");
            req.setAttribute("errorMessage", "Неверный логин или пароль!");
            req.getRequestDispatcher(req.getContextPath() + "/WEB-INF/login.jsp").forward(req, resp);
        }
    }
}
