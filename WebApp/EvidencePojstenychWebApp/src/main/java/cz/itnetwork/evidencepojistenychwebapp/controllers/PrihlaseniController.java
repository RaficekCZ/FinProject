package cz.itnetwork.evidencepojistenychwebapp.controllers;

import cz.itnetwork.evidencepojistenychwebapp.models.PrihlaseniDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class PrihlaseniController {

    @GetMapping("/prihlaseni")
    public String vypsaniPrihlaseni(@ModelAttribute PrihlaseniDTO prihlaseniDTO) {
        return "prihlaseni";
    }
}