package listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.CategoryDao;
import dao.TestDao;
import dao.UserDao;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import services.CategoryService;
import services.TestService;
import services.UserService;

import java.io.File;

@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ServletContext servletContext = sce.getServletContext();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        ObjectMapper objectMapper = new ObjectMapper();

        File fileCategories = new File("C:\\Users\\User\\IdeaProjects\\ProjectOnServlets\\data\\categories\\categories.json");
        File fileUsers = new File("C:\\Users\\User\\IdeaProjects\\ProjectOnServlets\\data\\users\\users.json");
        File fileTests = new File("C:\\Users\\User\\IdeaProjects\\ProjectOnServlets\\data\\tests\\tests.json");

        UserDao userDao = new UserDao(objectMapper, fileUsers);
        CategoryDao categoryDao = new CategoryDao(objectMapper, fileCategories);
        TestDao testDao = new TestDao(objectMapper, fileTests);

        UserService userService = new UserService(userDao, passwordEncoder);
        CategoryService categoryService = new CategoryService(categoryDao);
        TestService testService = new TestService(testDao);


        servletContext.setAttribute("userService", userService);
        servletContext.setAttribute("categoryService", categoryService);
        servletContext.setAttribute("testService", testService);

    }
}
