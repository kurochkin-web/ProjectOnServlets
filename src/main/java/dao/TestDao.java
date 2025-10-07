package dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Test;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

@RequiredArgsConstructor
public class TestDao {

    private final ObjectMapper objectMapper;
    private final File testDirectory;

    public void findAll() {
        creatingDirectory();
    }

    @SneakyThrows
    public void creatingDirectory() {
        if (!testDirectory.exists()) {
            Files.createDirectories(testDirectory.toPath());
        }
    }

}
