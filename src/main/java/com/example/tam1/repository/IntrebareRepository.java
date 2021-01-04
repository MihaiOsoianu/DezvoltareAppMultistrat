package com.example.tam1.repository;

import com.example.tam1.entity.Intrebare;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
public interface IntrebareRepository extends JpaRepository<Intrebare, Integer> {

}
