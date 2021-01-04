package com.example.tam1.controller;

import com.example.tam1.entity.Intrebare;
import com.example.tam1.service.IntrebareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IntrebareController {

    @Autowired
    private IntrebareService intrebareService;

    @GetMapping("/intrebari")
    public String index(Model model) {
        return findPaginated(1, model);
    }

    @GetMapping("/intrebari/create")
    public String create(Model model) {
        Intrebare intrebare = new Intrebare();
        model.addAttribute("intrebare", intrebare); //"key", value
        return "intrebari/create";
    }

    @PostMapping("/intrebari/save")
    public String store(@ModelAttribute("intrebare") Intrebare intrebare){
        intrebareService.saveIntrebare(intrebare);
        return "redirect:/intrebari/";
    }

    @GetMapping("/intrebari/edit/{id}")
    public String edit(@PathVariable( value = "id" ) Integer id, Model model) {
        //get intrebare from the service
        Intrebare intrebare = intrebareService.getIntrebareById(id);
        //set intrebare as a model attribute to pre-populate the form
        model.addAttribute("intrebare", intrebare);
        return "intrebari/edit";
    }


    @GetMapping("/intrebari/delete/{id}")
    public String destroy(@PathVariable (value = "id") Integer id) {
        intrebareService.deleteIntrebareById(id);
        return "redirect:/intrebari/";
    }


    @GetMapping("/intrebari/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo, Model model) {
        int pageSize = 5;
        Page<Intrebare> page = intrebareService.findPaginated(pageNo, pageSize);
        List<Intrebare> listIntrebari = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listIntrebari", listIntrebari);

        return "intrebari/index";
    }

}
