package com.example.tam1.controller;

import com.example.tam1.entity.Intrebare;
import com.example.tam1.entity.Test;
import com.example.tam1.entity.TestIntrebare;
import com.example.tam1.form.AddIntrebareTest;
import com.example.tam1.service.IntrebareService;
import com.example.tam1.service.TestIntrebareService;
import com.example.tam1.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private IntrebareService intrebareService;

    @Autowired
    private TestIntrebareService testIntrebareService;

    @GetMapping("/teste")
    public String index(Model model) {
        model.addAttribute("listTeste", testService.getAllTeste());
        return "teste/index";
    }

    @GetMapping("/teste/create")
    public String create(Model model) {
        Test test = new Test();
        model.addAttribute("test", test); //"key", value
        return "teste/create";
    }

    @GetMapping("/teste/show/{id}")
    public String show(@PathVariable( value = "id") Integer id, Model model) {
        Test test = testService.getTestById(id);
        model.addAttribute("test", test);
        model.addAttribute("listaIntrebari", test.getListaTestIntrebare());
        return "teste/show";
    }

    @PostMapping("/teste/save")
    public String store(@ModelAttribute("test") Test test){
//        if (!(test.getNrIntrebari() > 0)) {
//            test.setNrIntrebari(0);
//            test.setPunctaj(0.0f, 0.0f);
//        }
        testService.saveTest(test);
        return "redirect:/teste";
    }

    @GetMapping("teste/edit/{id}")
    public String edit(@PathVariable( value = "id" ) Integer id, Model model) {
        Test test = testService.getTestById(id);
        model.addAttribute("test", test);
        return "teste/edit";
    }

    @GetMapping("/teste/delete/{id}")
    public String destroy(@PathVariable (value = "id") Integer id) {
        this.testService.deleteTestById(id);
        return "redirect:/teste/";
    }

    @RequestMapping("/teste/intrebari/{id}")
    public String createIT(Model model, @PathVariable( value = "id") Integer id) {
        Test test = testService.getTestById(id);
        AddIntrebareTest form = new AddIntrebareTest(intrebareService.getAllIntrebare(), test);
        List<Intrebare> listaIntrebari = intrebareService.getAllIntrebare();
        listaIntrebari.removeAll(test.getListaIntrebari());
//        TestIntrebare testIntrebare = new TestIntrebare();
        model.addAttribute("test", test);
        model.addAttribute("listaIntrebari", listaIntrebari);
//        model.addAttribute("testintrebare", testIntrebare);
        model.addAttribute("form", form);
        return "teste/intrebari";
    }

    @PostMapping("teste/intrebari/save")
    public String storeIT(Model model,
                          @ModelAttribute @Valid AddIntrebareTest form,
                          Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("form", form);
            return "teste/intrebari";
        }
        Intrebare intrebarea = intrebareService.getIntrebareById(form.getIdIntrebare());
        Test testul = testService.getTestById(form.getIdTest());
        //testul.addTestIntrebare(new TestIntrebare(intrebarea, testul));
        //testService.saveTest(testul);
        Float punctaj = form.getPunctaj();
        testIntrebareService.saveTestIntrebare(new TestIntrebare(intrebarea, testul, punctaj));
        testul.setNrIntrebari(testul.getNrIntrebari() + 1);
        testul.setPunctaj(testul.getPunctajMaxim() + punctaj, testul.getPunctajMinimNecesar() + (punctaj/2));

        testService.saveTest(testul);
        return "redirect:/teste/intrebari/" + testul.getIdTest();
    }

    @GetMapping("/teste/intrebari/delete/{id}")
    public String destroyIT(@PathVariable (value = "id") Integer id) {
        TestIntrebare testIntrebare = this.testIntrebareService.getTestIntrebareById(id);
        Test test = testIntrebare.getTest();
        test.setNrIntrebari(test.getNrIntrebari() - 1);
        test.setPunctaj(test.getPunctajMaxim() - testIntrebare.getPunctaj(),
                test.getPunctajMinimNecesar() - (testIntrebare.getPunctaj()/2));
        this.testIntrebareService.deleteTestIntrebareById(id);
        return "redirect:/teste/";
    }

}
