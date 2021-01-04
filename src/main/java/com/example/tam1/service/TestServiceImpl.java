package com.example.tam1.service;

import com.example.tam1.entity.Intervievator;
import com.example.tam1.entity.Test;
import com.example.tam1.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository testRepository;

    @Override
    public List<Test> getAllTeste() {
        return testRepository.findAll();
    }

    @Override
    public void saveTest(Test test) {
        this.testRepository.save(test);
    }

    @Override
    public Test getTestById(Integer id) {
        Optional<Test> optional = testRepository.findById(id);
        Test test = null;
        if (optional.isPresent()) {
            test = optional.get();
        } else {
            throw new RuntimeException("Testul nu a fost gasit pentru id-ul " + id);
        }
        return test;
    }

    @Override
    public void deleteTestById(Integer id) {
        this.testRepository.deleteById(id);
    }
}
