package cz.itnetwork.evidencepojistenychwebapp.controllers;

import cz.itnetwork.evidencepojistenychwebapp.models.NovyPojistenecDTO;
import cz.itnetwork.evidencepojistenychwebapp.models.NovyPojistenecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PojistenciController {
    
@Autowired
private NovyPojistenecService novyPojistenecService;    

    @GetMapping("/pojistenci")
    public String vypsaniStrankyPojistenci() {
        return "pojistenci";
    }
    
    @GetMapping("/pojistenci/novy")
    public String vypsaniFormularNovyPojistenec(@ModelAttribute NovyPojistenecDTO novyPojistenecDTO) {
        return "pojistenciPridatPojistence";
    }

    @PostMapping
    public String zalozitNovehoPojistence(@ModelAttribute NovyPojistenecDTO novyPojistenecDTO) {
        novyPojistenecService.zalozitNovehoPojistence(novyPojistenecDTO);
        //model.addAttribute("result", result);
        return "prihlaseni";
    }    
}