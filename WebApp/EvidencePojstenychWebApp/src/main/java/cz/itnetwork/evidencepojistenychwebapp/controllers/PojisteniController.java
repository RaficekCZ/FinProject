package cz.itnetwork.evidencepojistenychwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PojisteniController {

    @GetMapping("/pojisteni")
    public String vypsaniPojistenci() {
        return "pojisteni";
    }
}