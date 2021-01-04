package com.example.tam1.rest;

import com.example.tam1.entity.Candidat;
import com.example.tam1.model.CandidatDto;
import com.example.tam1.service.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("candidati")
public class CandidatRestController {
//
//    @Autowired
//    private CandidatService candidatService;
//
//    @GetMapping
//    public List<Candidat> getAllCandidati() {
//        return candidatService.getAllCandidati();
//    }
//
//    @GetMapping("/{id}")
//    public CandidatDto getCandidatById(Model model, @PathVariable (value = "id") Integer id) {
//        CandidatDto candidatDto = candidatService.getCandidatByIdDTO(id);
//        model.addAttribute("candidatDto", candidatDto);
//        return candidatDto;
//    }
//
//    @PostMapping("/{id}")
//    public void updateCandidat(@PathVariable (value = "id") Integer id,
//                               @ModelAttribute("candidatDto") CandidatDto candidatDto) {
//
//        Candidat candidat = candidatService.getCandidatById(id);
//        candidatService.updateCandidat(id, candidatDto);
//
//    }

}
