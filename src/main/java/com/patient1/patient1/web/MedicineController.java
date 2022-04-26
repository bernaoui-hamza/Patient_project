package com.patient1.patient1.web;

import com.patient1.patient1.entities.Medecin;
import com.patient1.patient1.entities.RendezVous;
import com.patient1.patient1.repositories.MedicinRepository;

import com.patient1.patient1.repositories.RdvRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class MedicineController {
    private MedicinRepository medecinRepository;
    private RdvRepository rdvRepository;

    @GetMapping(path = "/admin/index2")
    public String medecin(Model model,
                           @RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "size", defaultValue = "5") int size,
                           @RequestParam(name = "keyword", defaultValue = "") String keyword
    ) {
        Page<Medecin> m1 = medecinRepository.findByNomMedecinContains(keyword, PageRequest.of(page, size));
        model.addAttribute("ListMedecins", m1);
        model.addAttribute("pages", new int[m1.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);

        return "medecins";
    }
@GetMapping(path = "/user/rdv")
    public String rdv(Model model){

        return "rdv";

    }
    @PostMapping(path = "/user/saveRDV")
    public String saveRDV(Model model, RendezVous rendez_vous){
        rdvRepository.save(rendez_vous);
        String rep="true";
        model.addAttribute("ajouter", rep);
        return "redirect:/user/index";
    }

    @GetMapping(path = "/admin/delete2")
    public String delete(Long id, String keyword, int page) {
        medecinRepository.deleteById(id);
        return "redirect:/admin/index2?page=" + page + "&keyword=" + keyword;
    }



    /*
     @GetMapping(path = "/")
    public String home() {
        return "home";
    }
    @GetMapping(path = "/admin/formPatients")
    public String formPatients(Model model) {

        model.addAttribute("p1", new Medecin());
        String s = "formulairePatient";
        return s;
    }

    @PostMapping(path = "/admin/save")
    public String save(Model model,  Medecin medecin){
        //if(bindingResult.hasErrors()) return  "redirect:/index";
        medecinRepository.save(medecin);
        return "redirect:/user/index";
    }
    @GetMapping(path = "/admin/editeMedecin")
    public String editeMedecin(Model model,Long id) {
        Medecin m1=medecinRepository.findById(id).orElse(null);
        if (m1==null)throw new RuntimeException("medecin Introuvable");
         model.addAttribute("m1", m1);

        return "editPatient";
    }*/
    /*@PostMapping(path = "/editer")
    public String editer(Model model,Patient patient){
        String n=model.getAttribute("nom").toString();
        String dtN=model.getAttribute("dateNaissance").toString();
        Date dt=new Date(dtN);
        String sc=model.getAttribute("score").toString();
        boolean malade= (boolean) model.getAttribute("malade");

        return "";
    }
*/
}
