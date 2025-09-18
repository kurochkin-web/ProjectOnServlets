package dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.User;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class UserDao {

    private final ObjectMapper objectMapper;
    private final File file;

    @SneakyThrows
    public void save(User user) {
        List<User> list = findAll();
        list.add(user);
        objectMapper.writeValue(file, list);

        //Прочитали весь файл и вернули в виде листа юзеров
        //Добавили туда еще одного, который пришел в качестве аргумента
        //Перезаписали весь JSON
    }

    @SneakyThrows
    public List<User> findAll() {
        return objectMapper.readValue(file, new TypeReference<List<User>>() {
        });
    }


}
