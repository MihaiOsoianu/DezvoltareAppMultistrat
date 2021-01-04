package com.example.tam1.service;

import com.example.tam1.entity.Interviu;
import com.example.tam1.repository.InterviuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InterviuServiceImpl implements InterviuService{

    @Autowired
    private InterviuRepository interviuRepository;

    @Override
    public List<Interviu> getAllInterviuri() {
        return interviuRepository.findAll();
    }

    @Override
    public void saveInterviu(Interviu interviu) {
        this.interviuRepository.save(interviu);
    }

    @Override
    public Interviu getInterviuById(Integer id) {
        Optional<Interviu> optional = interviuRepository.findById(id);
        Interviu interviu = null;
        if (optional.isPresent()) {
            interviu = optional.get();
        } else {
            throw new RuntimeException("Interviul nu a fost gasit pentru id-ul " + id);
        }
        return interviu;
    }

    @Override
    public void deleteInterviuById(Integer id) {
        this.interviuRepository.deleteById(id);
    }
}
