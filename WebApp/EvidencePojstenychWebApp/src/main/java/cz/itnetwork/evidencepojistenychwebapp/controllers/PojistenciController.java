package cz.itnetwork.evidencepojistenychwebapp.controllers;

import cz.itnetwork.evidencepojistenychwebapp.models.PojistenecDTO;
import cz.itnetwork.evidencepojistenychwebapp.models.PojistenecService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PojistenciController {
    
@Autowired
private PojistenecService pojistenecService;    

    @GetMapping("/pojistenci")
    public String vypsaniStrankyPojistenci(/*@ModelAttribute PojistenecDTO pojistenecDTO,*/ Model model) {
        List<PojistenecDTO> pojistenci = pojistenecService.ziskaniVsechPojistencu();
        model.addAttribute("seznamPojistencu", pojistenci);
        return "pojistenci";
    }
    
    @GetMapping("/pojistenci/novy")
    public String vypsaniFormularNovyPojistenec(@ModelAttribute PojistenecDTO pojistenecDTO) {
        return "pojistenciPridatPojistence";
    }

    @PostMapping("/pojistenci/novy")
    public String zalozitNovehoPojistence(@ModelAttribute PojistenecDTO pojistenecDTO) {
        pojistenecService.zalozitNovehoPojistence(pojistenecDTO);
        return "pojistenciResult";
    }    
}