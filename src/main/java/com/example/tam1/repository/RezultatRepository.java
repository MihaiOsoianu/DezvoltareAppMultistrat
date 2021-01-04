package com.example.tam1.repository;

import com.example.tam1.entity.Rezultat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RezultatRepository extends JpaRepository<Rezultat, Integer> {
}
