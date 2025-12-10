package services;

import dao.TestDao;
import entity.Test;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class TestService {
    TestDao testDao;

    /*public List<Test> findListTestsByID(List<UUID> list) {

        List<Test> tests = list.stream()
                .map(id -> testDao.findById(id))
                .filter(optTest -> optTest.isPresent())
                .map(optTest -> optTest.get())
                .toList();

        return tests;
    }*/
}


