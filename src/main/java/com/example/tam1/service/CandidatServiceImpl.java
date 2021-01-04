package com.example.tam1.service;

import com.example.tam1.entity.Candidat;
import com.example.tam1.repository.CandidatRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CandidatServiceImpl implements CandidatService{

    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private CandidatRepository candidatRepository;

    @Override
    public List<Candidat> getAllCandidati() {
        return candidatRepository.findAll();
    }

    @Override
    public void saveCandidat(Candidat candidat) {
        this.candidatRepository.save(candidat);
    }

    @Override
    public Candidat getCandidatById(Integer id) {
        return modelMapper.map(candidatRepository.findByIdPersoana(id), Candidat.class);
    }

    @Override
    public void deleteCandidatById(Integer id) {
        candidatRepository.deleteById(id);
    }
}
