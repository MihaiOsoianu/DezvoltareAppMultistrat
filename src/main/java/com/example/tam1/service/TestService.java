package com.example.tam1.service;

import com.example.tam1.entity.Test;

import java.util.List;

public interface TestService {
    List<Test> getAllTeste();
    void saveTest(Test test);
    Test getTestById(Integer id);
    void deleteTestById(Integer id);
}
