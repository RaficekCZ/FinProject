package cz.itnetwork.evidencepojistenychwebapp.controllers;

import cz.itnetwork.evidencepojistenychwebapp.models.PojistenecDTO;
import cz.itnetwork.evidencepojistenychwebapp.models.PojistenecService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pojistovna/pojistenci")
public class PojistenciController {
    
@Autowired
private PojistenecService pojistenecService;

    @GetMapping()
    public String vypsaniStrankyPojistenci(Model model) {
        List<PojistenecDTO> pojistenciDTO = pojistenecService.ziskatVsechnyPojistence();
        model.addAttribute("seznamPojistencuDTO", pojistenciDTO);
        return "pojistenci";
    }
    
    @GetMapping("novy")
    public String vypsaniFormularNovyPojistenec(@ModelAttribute PojistenecDTO pojistenecDTO) {
        return "pojistenciPridatPojistence";
    }

    @PostMapping("novy")
    public String zalozitNovehoPojistence(@ModelAttribute PojistenecDTO pojistenecDTO) {
        pojistenecService.zalozitPojistence(pojistenecDTO);
        return "pojistenciResult";
    }
    
    @GetMapping("detail/{id}")
    public String vypsaniStrankyDetailuPojistence(@PathVariable("id") String id, Model model) {
        PojistenecDTO pojistenecDTO = pojistenecService.ziskatDetailPojistence(id);
        model.addAttribute("pojistenecDTO", pojistenecDTO);
        return "pojistenciDetail";
    }
    
    @GetMapping("editace/{id}")
    public String vypsaniFormularEditacePojistence(@PathVariable("id") String id, Model model) {
        PojistenecDTO pojistenecDTO = pojistenecService.ziskatDetailPojistence(id);
        model.addAttribute("pojistenecDTO", pojistenecDTO);
        return "pojistenciEditovatPojistence";
    }

    @PostMapping("editace")
    public String editovatPojistence(@ModelAttribute PojistenecDTO pojistenecDTO) {
        pojistenecService.editovatPojistence(pojistenecDTO);
        return "pojistenciResult";
    }
    
    @PostMapping("smazani")
    public String smazaniPojistence(@ModelAttribute PojistenecDTO pojistenecDTO) {
        pojistenecService.smazatPojistence(pojistenecDTO);
        return "pojistenciResult";
    }
}