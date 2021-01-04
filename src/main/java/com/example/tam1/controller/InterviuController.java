package com.example.tam1.controller;

import com.example.tam1.entity.Interviu;
import com.example.tam1.service.CandidatService;
import com.example.tam1.service.IntervievatorService;
import com.example.tam1.service.InterviuService;
import com.example.tam1.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class InterviuController {

    @Autowired
    private InterviuService interviuService;

    @Autowired
    private CandidatService candidatService;

    @Autowired
    private IntervievatorService intervievatorService;

    @Autowired
    private TestService testService;

    @GetMapping("/interviuri")
    public String index(Model model) {
        List<Interviu> interviuri = interviuService.getAllInterviuri();
        List<Interviu> interviuriV = interviuri.stream()
                .filter( i -> (i.getData().compareTo(new Timestamp(System.currentTimeMillis()))) > 0)
                .collect(Collectors.toList());
        List<Interviu> interviuriP = interviuri;
        interviuriP.removeAll(interviuriV);
        model.addAttribute("interviuriV", interviuriV);
        model.addAttribute("interviuriP", interviuriP);

        return "interviuri/index";
    }

    @GetMapping("/interviuri/create")
    public String create(Model model) {
        Interviu interviu = new Interviu();
        model.addAttribute("interviu", interviu);
        model.addAttribute("candidati", candidatService.getAllCandidati());
        model.addAttribute("intervievatori", intervievatorService.getAllIntervievatori());
        model.addAttribute("teste", testService.getAllTeste());
        return "interviuri/create";
    }

    @PostMapping("/interviuri/save")
    public String store(@ModelAttribute("interviu") Interviu interviu) {
        interviuService.saveInterviu(interviu);
        return "redirect:/interviuri";
    }

    @GetMapping("/interviuri/edit/{id}")
    public String edit(@PathVariable(value="id") Integer id, Model model) {
        Interviu interviu = interviuService.getInterviuById(id);
        System.out.println(interviu.getTip());

        model.addAttribute("interviu", interviu);
        model.addAttribute("candidati", candidatService.getAllCandidati());
        model.addAttribute("intervievatori", intervievatorService.getAllIntervievatori());
        model.addAttribute("teste", testService.getAllTeste());
        return "interviuri/edit";
    }

    @GetMapping("/interviuri/delete/{id}")
    public String destroy(@PathVariable(value="id") Integer id) {
        interviuService.deleteInterviuById(id);
        return "redirect:/interviuri/";
    }

    @GetMapping("/interviuri/show/{id}")
    public String show(@PathVariable(value="id") Integer id, Model model) {
        Interviu interviu = interviuService.getInterviuById(id);
        model.addAttribute("interviu", interviu);
        if (interviu.getData().compareTo(new Timestamp(System.currentTimeMillis())) > 0) {
            model.addAttribute("poateSustineTestul", false);
        } else {
            model.addAttribute("poateSustineTestul", true);
        }
        return "interviuri/show";
//        getData().compareTo(new Timestamp(System.currentTimeMillis()))) > 0
    }

}
