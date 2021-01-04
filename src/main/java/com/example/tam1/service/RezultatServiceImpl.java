package com.example.tam1.service;

import com.example.tam1.entity.Rezultat;
import com.example.tam1.repository.RezultatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RezultatServiceImpl implements RezultatService{

    @Autowired
    private RezultatRepository rezultatRepository;

    @Override
    public void saveRezultat(Rezultat rezultat) {
        this.rezultatRepository.save(rezultat);
    }

}
