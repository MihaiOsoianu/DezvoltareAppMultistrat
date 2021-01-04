package com.example.tam1.repository;

import com.example.tam1.entity.Candidat;
import com.example.tam1.entity.Intervievator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IntervievatorRepository extends JpaRepository<Intervievator, Integer> {

    List<Intervievator> findAll();
    Intervievator findByIdPersoana(Integer idPersoana);

    @Modifying
    @Transactional
    @Query("update Intervievator i set i.specializare=:specializare, i.nume=:nume, i.prenume=:prenume where i.idPersoana=:id")
    void updateIntervievator(@Param("id") Integer id, @Param("specializare") String specializare,
                        @Param("nume") String surname, @Param("prenume") String prenume);
}
