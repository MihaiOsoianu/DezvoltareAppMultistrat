package com.example.tam1.repository;

import com.example.tam1.entity.TestIntrebare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestIntrebareRepository extends JpaRepository<TestIntrebare, Integer> {
}
