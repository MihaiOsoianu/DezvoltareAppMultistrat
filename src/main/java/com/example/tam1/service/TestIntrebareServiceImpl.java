package com.example.tam1.service;

import com.example.tam1.entity.Test;
import com.example.tam1.entity.TestIntrebare;
import com.example.tam1.repository.TestIntrebareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class TestIntrebareServiceImpl implements TestIntrebareService {

    @Autowired
    private TestIntrebareRepository testIntrebareRepository;

    @Override
    public void saveTestIntrebare(TestIntrebare testIntrebare) {
            this.testIntrebareRepository.save(testIntrebare);
    }

    @Override
    public void deleteTestIntrebareById(Integer id) {
        this.testIntrebareRepository.deleteById(id);
    }

    @Override
    public TestIntrebare getTestIntrebareById(Integer id) {
        Optional<TestIntrebare> optional = testIntrebareRepository.findById(id);
        TestIntrebare testIntrebare = null;
        if( optional.isPresent()) {
            testIntrebare = optional.get();
        } else {
            throw new RuntimeException("Intrebarea asociata testului nu a fost gasita! Id-ul intrebarii este " + id);
        }
        return testIntrebare;
    }

}
