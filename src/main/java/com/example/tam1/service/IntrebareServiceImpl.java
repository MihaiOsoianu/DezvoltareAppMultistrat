package com.example.tam1.service;

import com.example.tam1.entity.Intrebare;
import com.example.tam1.model.IntrebareDto;
import com.example.tam1.repository.IntrebareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class IntrebareServiceImpl implements IntrebareService{

    @Autowired
    private IntrebareRepository intrebareRepository;

    @Override
    public List<Intrebare> getAllIntrebare() {
        return intrebareRepository.findAll();
    }

    @Override
    public void saveIntrebare(Intrebare intrebare) {
        this.intrebareRepository.save(intrebare);
    }

    @Override
    public Intrebare getIntrebareById(Integer id) {
        Optional<Intrebare> optional = intrebareRepository.findById(id);
        Intrebare intrebare = null;
        if (optional.isPresent()) {
            intrebare = optional.get();
        } else {
            throw new RuntimeException("Intrebarea nu a fost gasita pentru id-ul " + id);
        }
        return intrebare;
    }

    @Override
    public void deleteIntrebareById(Integer id) {
        this.intrebareRepository.deleteById(id);
    }

    @Override
    public Page<Intrebare> findPaginated(int pageNo, int pageSize) {
        //PageRequest class -> AbstractPageRequest interface -> Pageable interface
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.intrebareRepository.findAll(pageable);
    }
}
