package dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Test;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class TestDao {

    /*private final ObjectMapper objectMapper;
    private final File testDirectory;

    @SneakyThrows
    public Optional<Test> findById(UUID id) {
        File file = new File(testDirectory, id.toString()+".json");
        if(file.exists()) {
            Test test = objectMapper.readValue(file, Test.class);
            return Optional.of(test);
        }
        return Optional.empty();
    }

    @SneakyThrows
    public void creatingDirectory() {
        if (!testDirectory.exists()) {
            Files.createDirectories(testDirectory.toPath());
        }
    }


*/
}
