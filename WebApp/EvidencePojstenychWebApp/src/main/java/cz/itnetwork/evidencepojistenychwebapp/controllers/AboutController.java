package cz.itnetwork.evidencepojistenychwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pojistovna/about")
public class AboutController {

    @GetMapping()
    public String vypsaniAbout() {
        return "about";
    }
}