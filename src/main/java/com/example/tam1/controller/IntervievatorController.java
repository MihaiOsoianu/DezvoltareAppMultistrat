package com.example.tam1.controller;

import com.example.tam1.entity.Intervievator;
import com.example.tam1.service.IntervievatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IntervievatorController {

    @Autowired
    private IntervievatorService intervievatorService;

    @GetMapping("/intervievatori")
    public String index(Model model) {
        model.addAttribute("listIntervievatori", intervievatorService.getAllIntervievatori());
        return "intervievatori/index";
    }

    @GetMapping("/intervievatori/create")
    public String create(Model model) {
        Intervievator intervievator = new Intervievator();
        model.addAttribute("intervievator", intervievator); //"key", value
        return "intervievatori/create";
    }

    @PostMapping("/intervievatori/save")
    public String store(@ModelAttribute("intervievator") Intervievator intervievator){
        intervievatorService.saveIntervievator(intervievator);
        return "redirect:/intervievatori";
    }

    @GetMapping("/intervievatori/edit/{id}")
    public String edit(@PathVariable(value = "id") Integer id, Model model) {
        Intervievator intervievator = intervievatorService.getIntervievatorById(id);
        model.addAttribute("intervievator", intervievator);
        return "intervievatori/edit";
    }

    @GetMapping("/intervievatori/delete/{id}")
    public String destroy(@PathVariable (value="id") Integer id) {
        this.intervievatorService.deleteIntervievatorById(id);
        return "redirect:/intervievatori";
    }

}
