package cz.itnetwork.evidencepojistenychwebapp.controllers;

import cz.itnetwork.evidencepojistenychwebapp.models.PrihlaseniDTO;
import cz.itnetwork.evidencepojistenychwebapp.models.PrihlaseniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PrihlaseniController {
    
@Autowired
private PrihlaseniService prihlaseniService;    

    @GetMapping("/prihlaseni")
    public String vypsaniPrihlaseni(@ModelAttribute PrihlaseniDTO prihlaseniDTO) {
        return "prihlaseni";
    }
    
    @PostMapping("/prihlaseni")
    public String calculate(@ModelAttribute PrihlaseniDTO prihlaseniDTO, Model model) {
        String jmeno = prihlaseniService.vypis(prihlaseniDTO);
        model.addAttribute("jmeno", jmeno);
        return "prihlaseniResult";
    }    
}