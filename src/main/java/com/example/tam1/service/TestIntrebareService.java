package com.example.tam1.service;

import com.example.tam1.entity.TestIntrebare;

public interface TestIntrebareService {

    void saveTestIntrebare(TestIntrebare testIntrebare);
    void deleteTestIntrebareById(Integer id);
    TestIntrebare getTestIntrebareById(Integer id);

}
