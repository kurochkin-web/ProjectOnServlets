package dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Category;
import entity.Test;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class CategoryDao {

    private final ObjectMapper objectMapper;
    private final File file;
    //Перенести в лисенер

    @SneakyThrows
    public List<Category> findAll() {
       return objectMapper.readValue(file, new TypeReference<>() {});
    }
}
