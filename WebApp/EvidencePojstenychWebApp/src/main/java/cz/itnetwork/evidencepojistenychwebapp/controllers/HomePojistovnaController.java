package cz.itnetwork.evidencepojistenychwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pojistovna")
public class HomePojistovnaController {

    @GetMapping()
    public String vypsaniHome() {
        return "home";
    }
}