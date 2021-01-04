package com.example.tam1.service;

import com.example.tam1.entity.Interviu;

import java.util.List;

public interface InterviuService {

    List<Interviu> getAllInterviuri();
    void saveInterviu(Interviu interviu);
    Interviu getInterviuById(Integer id);
    void deleteInterviuById(Integer id);

}
