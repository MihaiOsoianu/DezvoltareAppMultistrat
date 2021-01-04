package com.example.tam1.service;

import com.example.tam1.entity.Candidat;
import com.example.tam1.entity.Intervievator;
import com.example.tam1.entity.Intrebare;
import com.example.tam1.model.CandidatDto;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IntervievatorService {

List<Intervievator> getAllIntervievatori();
void saveIntervievator(Intervievator intervievator);
Intervievator getIntervievatorById(Integer id);
void deleteIntervievatorById(Integer id);

}

//    private final ModelMapper modelMapper = new ModelMapper();

//    public List<Candidat> getAllCandidati() {
//        return candidatRepository.findAll();
//    }
//
//    public CandidatDto getCandidatById(Integer candidatId) {
//        return modelMapper.map(candidatRepository.findByIdPersoana(candidatId), CandidatDto.class);
//    }
//
//    public void updateCandidat(Integer candidatId, CandidatDto candidatDto) {
//        candidatRepository.updateCandidat(candidatId, candidatDto.getEmail(), candidatDto.getTelefon(),
//                candidatDto.getNume(), candidatDto.getPrenume());
//    }
//
//
//    public Candidat getCandidatByIdObject(Integer candidatId) {
//        return candidatRepository.findByIdPersoana(candidatId);
//    }
//
//    public void deleteCandidat(Integer candidatId) {
//        candidatRepository.deleteById(candidatId);
//    }