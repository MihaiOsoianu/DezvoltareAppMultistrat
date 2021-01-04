package com.example.tam1.controller;

import com.example.tam1.entity.Candidat;
import com.example.tam1.service.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/candidati")
public class CandidatController {

    @Autowired
    private CandidatService candidatService;


    @GetMapping
    public String index(Model model) {
        model.addAttribute("listCandidati", candidatService.getAllCandidati());
        return "candidati/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        Candidat candidat = new Candidat();
        model.addAttribute("candidat", candidat);
        return "candidati/create";
    }

    @PostMapping("/save")
    public String store(@ModelAttribute("candidat") Candidat candidat) {
        candidatService.saveCandidat(candidat);
        return "redirect:/candidati";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(value="id") Integer id, Model model) {
        Candidat candidat = candidatService.getCandidatById(id);
        model.addAttribute("candidat", candidat);
        return "candidati/edit";
    }

    @GetMapping("/delete/{id}")
    public String destroy(@PathVariable (value="id") Integer id) {
        this.candidatService.deleteCandidatById(id);
        return "redirect:/candidati";
    }

}
