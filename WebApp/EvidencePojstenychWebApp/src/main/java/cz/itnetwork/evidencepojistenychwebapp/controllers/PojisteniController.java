package cz.itnetwork.evidencepojistenychwebapp.controllers;

import cz.itnetwork.evidencepojistenychwebapp.models.PojisteniDTO;
import cz.itnetwork.evidencepojistenychwebapp.models.PojisteniService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PojisteniController {
    
@Autowired
private PojisteniService pojisteniService;  

    @GetMapping("/pojisteni")
    public String vypsaniStrankyPojisteni(/*@ModelAttribute PojisteniDTO pojisteniDTO,*/ Model model) {
        List<PojisteniDTO> pojisteni = pojisteniService.ziskaniVsechPojisteni();
        model.addAttribute("seznamPojisteni", pojisteni);
        return "pojisteni";
    }
    
    @GetMapping("/pojisteni/novy")
    public String vypsaniFormularNovyPojistenec(@ModelAttribute PojisteniDTO pojisteniDTO) {
        return "pojisteniPridatPojisteni";
    }
    
    @PostMapping("/pojisteni/novy")
    public String zalozitNovehoPojistence(@ModelAttribute PojisteniDTO pojisteniDTO) {
        pojisteniService.zalozitNovePojisteni(pojisteniDTO);
        return "pojisteniResult";
    }       
}