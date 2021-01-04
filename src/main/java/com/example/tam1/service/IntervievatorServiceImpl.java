package com.example.tam1.service;


import com.example.tam1.entity.Intervievator;
import com.example.tam1.repository.IntervievatorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IntervievatorServiceImpl implements IntervievatorService{

    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private IntervievatorRepository intervievatorRepository;

    @Override
    public List<Intervievator> getAllIntervievatori() {
        return intervievatorRepository.findAll();
    }

    @Override
    public void saveIntervievator(Intervievator intervievator) {
        this.intervievatorRepository.save(intervievator);
    }

    @Override
    public Intervievator getIntervievatorById(Integer id) {
        return modelMapper.map(intervievatorRepository.findByIdPersoana(id), Intervievator.class);
//        return modelMapper.map(candidatRepository.findByIdPersoana(candidatId), CandidatDto.class);
    }
//    public CandidatDto getCandidatById(Integer candidatId) {
//        return modelMapper.map(candidatRepository.findByIdPersoana(candidatId), CandidatDto.class);
//    }
//    Optional<Intrebare> optional = intrebareRepository.findById(id);
//    Intrebare intrebare = null;
//        if (optional.isPresent()) {
//        intrebare = optional.get();
//    } else {
//        throw new RuntimeException("Intrebarea nu a fost gasita pentru id-ul " + id);
//    }
//        return intrebare;

    @Override
    public void deleteIntervievatorById(Integer id) {
        intervievatorRepository.deleteById(id);
    }
}
