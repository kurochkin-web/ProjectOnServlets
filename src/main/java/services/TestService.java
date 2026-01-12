package services;

import dao.TestDao;
import entity.Test;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class TestService {
    private final TestDao testDao;

    public List<Test> getAllTests() {
        return testDao.findAll();
    }

    public Test getTestById (Integer id) {
        List<Test> listTests = testDao.findAll();

        Test result;
        result = listTests.stream()
                .filter(test -> test.getId().equals(id))
                .findFirst()
                .orElse(null);

        return result;
    }

    /*public List<Test> findListTestsByID(List<UUID> list) {

        List<Test> tests = list.stream()
                .map(id -> testDao.findById(id))
                .filter(optTest -> optTest.isPresent())
                .map(optTest -> optTest.get())
                .toList();

        return tests;
    }*/
}


