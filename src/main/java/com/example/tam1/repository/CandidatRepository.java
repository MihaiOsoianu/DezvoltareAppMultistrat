package com.example.tam1.repository;

import com.example.tam1.entity.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CandidatRepository extends JpaRepository<Candidat, Integer> {

    List<Candidat> findAll();

    Candidat findByIdPersoana(Integer idPersoana);

    @Modifying
    @Transactional
    @Query("update Candidat c set c.email=:email, c.telefon=:telefon, c.nume=:nume, c.prenume=:prenume where c.idPersoana=:id")
    void updateCandidat(@Param("id") Integer id, @Param("email") String email, @Param("telefon") String telefon,
                        @Param("nume") String surname, @Param("prenume") String prenume);

}
