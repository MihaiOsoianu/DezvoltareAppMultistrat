package com.example.tam1.service;

import com.example.tam1.entity.Intrebare;
import com.example.tam1.model.IntrebareDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IntrebareService {
    List<Intrebare> getAllIntrebare();
    void saveIntrebare(Intrebare intrebare);
//    void updateIntrebare(Integer id, Intrebare intrebare);//test
    Intrebare getIntrebareById(Integer id);
    void deleteIntrebareById(Integer id);
    Page<Intrebare> findPaginated(int pageNo, int pageSize);
}
