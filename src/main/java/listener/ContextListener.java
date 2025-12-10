package listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.CategoryDao;
import dao.UserDao;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import services.CategoryService;
import services.UserService;

import java.io.File;

@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        ObjectMapper objectMapper = new ObjectMapper();
        File fileCategories = new File("C:\\Users\\User\\IdeaProjects\\ProjectOnServlets\\data\\categories\\categories.json");
        File fileUsers = new File("C:\\Users\\User\\IdeaProjects\\ProjectOnServlets\\data\\users\\users.json");
        UserDao userDao = new UserDao(objectMapper, fileUsers);
        CategoryDao categoryDao = new CategoryDao(objectMapper, fileCategories);



        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        UserService userService = new UserService(userDao, passwordEncoder);
        CategoryService categoryService = new CategoryService(categoryDao);


        servletContext.setAttribute("userService", userService);
        servletContext.setAttribute("categoryService", categoryService);

    }
}
