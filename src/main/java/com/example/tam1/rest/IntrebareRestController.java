package com.example.tam1.rest;

import com.example.tam1.entity.Intrebare;
import com.example.tam1.service.IntrebareService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("intrebari")
public class IntrebareRestController {

    @Autowired
    private IntrebareService intrebareService;

    final ModelMapper modelMapper = new ModelMapper();

    // display list of questions
    @GetMapping("/intrebariRest")
    public List<Intrebare> viewIntrebari() {
        return intrebareService.getAllIntrebare();
    }


}
