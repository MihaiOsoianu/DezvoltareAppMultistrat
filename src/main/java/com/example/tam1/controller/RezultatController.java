package com.example.tam1.controller;

import com.example.tam1.entity.Interviu;
import com.example.tam1.entity.Rezultat;
import com.example.tam1.entity.Test;
import com.example.tam1.entity.TestIntrebare;
import com.example.tam1.service.InterviuService;
import com.example.tam1.service.IntrebareService;
import com.example.tam1.service.RezultatService;
import com.example.tam1.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class RezultatController {

    @Autowired
    private RezultatService rezultatService;

    @Autowired
    private TestService testService;

    @Autowired
    private InterviuService interviuService;

    @Autowired
    private IntrebareService intrebareService;

    @RequestMapping("/interviu/{idInterviu}/test/{idTest}")
    public String create(@PathVariable( value = "idTest") Integer idTest,
                         @PathVariable( value = "idInterviu" ) Integer idInterviu,
                         Model model) {

        Test test = testService.getTestById(idTest);

        model.addAttribute("listaIntrebari", test.getListaTestIntrebare());
        model.addAttribute("interviu", interviuService.getInterviuById(idInterviu));
        model.addAttribute("test", testService.getTestById(idTest));

        return "test/create";
    }

    @PostMapping("/rezultat")
    public String store(HttpServletRequest request, Model model) {

        String []intrebariId = request.getParameterValues("intrebareId");

        String []idTest = request.getParameterValues("idTest");
        Integer test = Integer.parseInt(idTest[0]);

        String []idInterviu = request.getParameterValues("idInterviu");
        Integer interviu = Integer.parseInt(idInterviu[0]);

        System.out.println("ALOOOOOOOOOOOOOOOHAAAAAAAAAAAAAAAAAA");
        System.out.println("Id ul testului este " + test);
        Float punctaj = 0.0f;

        for (int i = 0; i < intrebariId.length; i++) {

            String[] raspuns = request.getParameterValues(intrebariId[i]);
            Integer idIntrebare = Integer.parseInt(intrebariId[i]);
            if (Arrays.asList(raspuns).contains(intrebareService.getIntrebareById(Integer.parseInt(intrebariId[i])).getRaspunsCorect())) {
                TestIntrebare testIntrebare = testService.getTestById(test).getListaTestIntrebare().stream().filter(item -> item.getIntrebare().getIdIntrebare().equals(idIntrebare)).findFirst().get();
                System.out.println("Raspunsul este corect");
                System.out.println(testIntrebare.getPunctaj());
                punctaj += testIntrebare.getPunctaj();
            } else {
                System.out.println("Raspunsul este gresit");
            }


            System.out.println(intrebariId[i]);
            System.out.println(Arrays.toString(raspuns));
        }

        Rezultat rezultat = new Rezultat();
        rezultat.setPunctaj(punctaj);

        rezultatService.saveRezultat(rezultat);

        Interviu interviul = interviuService.getInterviuById(interviu);
        interviul.setRezultat(rezultat);

        interviuService.saveInterviu(interviul);

        model.addAttribute("rezultat", rezultat);
        model.addAttribute("test", testService.getTestById(test));

        return "test/show";
    }


}
