package cz.itnetwork.evidencepojistenychwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PojistenciController {

    @GetMapping("/pojistenci")
    public String vypsaniPojistenci() {
        return "pojistenci";
    }
}