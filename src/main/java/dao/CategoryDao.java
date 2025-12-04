package dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Test;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.io.File;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class CategoryDao {

    private final ObjectMapper objectMapper;

    @SneakyThrows
    public Optional<Test> findById(UUID id) {
        File file = new File(testDirectory, id.toString()+".json");
        if(file.exists()) {
            Test test = objectMapper.readValue(file, Test.class);
            return Optional.of(test);
        }
        return Optional.empty();
    }
}
