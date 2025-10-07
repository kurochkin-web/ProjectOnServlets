package services;

import dao.UserDao;
import entity.Role;
import entity.User;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import servlets.LoginServlet;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;
    private final BCryptPasswordEncoder passwordEncoder;
    private static final Logger log = Logger.getLogger(LoginServlet.class.getName());

    public void save(String login, String password) {

        String encodePassword = passwordEncoder.encode(password);
        User user = User.builder()
                .id(UUID.randomUUID())
                .login(login)
                .password(encodePassword)
                .role(Role.USER)
                .build();
        log.info("Юзер создан" + user.getId());
        userDao.save(user);

        //Энкодим пароль, создаем юзера и через UserDao сохраняем
    }

    public Optional<User> findUserByCredentials(String login, String password) {
        List<User> users = userDao.findAll();

        return users.stream()
                .filter(user -> user.getLogin().equals(login))
                .filter(user -> passwordEncoder.matches(password, user.getPassword()))
                .findFirst();

        //Получаем в users всех юзеров в json'е
        //фильтруем по логину и паролю
        //все в Optional поэтому берем что там отфильтровалось и возвращаем результатом метода
    }
}
