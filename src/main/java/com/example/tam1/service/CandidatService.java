package com.example.tam1.service;

import com.example.tam1.entity.Candidat;
import java.util.List;


public interface CandidatService {

    List<Candidat> getAllCandidati();
    void saveCandidat(Candidat candidat);
    Candidat getCandidatById(Integer id);
    void deleteCandidatById(Integer id);

//    @Autowired
//    CandidatRepository candidatRepository;

//@PersistenceContext
//private EntityManager entityManager;

//    private final ModelMapper modelMapper = new ModelMapper();
//
//    public List<Candidat> getAllCandidati() {
//        return candidatRepository.findAll();
//    }
//
//    public CandidatDto getCandidatByIdDTO(Integer candidatId) {
//        return modelMapper.map(candidatRepository.findByIdPersoana(candidatId), CandidatDto.class);
//    }
//
//    public void updateCandidat(Integer candidatId, CandidatDto candidatDto) {
//        candidatRepository.updateCandidat(candidatId, candidatDto.getEmail(), candidatDto.getTelefon(),
//                candidatDto.getNume(), candidatDto.getPrenume());
//    }
//
//
//    public Candidat getCandidatById(Integer candidatId) {
//        return candidatRepository.findByIdPersoana(candidatId);
//    }
//
//    public void deleteCandidat(Integer candidatId) {
//        candidatRepository.deleteById(candidatId);
//    }


//    @Transactional
//    public void insertWithQuery(Candidat candidat) {
//        entityManager.createNativeQuery("INSERT INTO Candidat(email, telefon, nume, " +
//                "prenume) VALUES (?,?,?,?)")
//                .setParameter(1, candidat.getEmail())
//                .setParameter(2, candidat.getTelefon())
//                .setParameter(3, candidat.getNume())
//                .setParameter(4, candidat.getPrenume())
//                .executeUpdate();
//    }
//
//    @Transactional
//    public void insertWithEntityManager(Candidat candidat) {
//        this.entityManager.persist(candidat);
//    }

}
