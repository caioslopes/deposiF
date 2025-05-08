package br.edu.ifsp.deposif.web;

import br.edu.ifsp.deposif.model.Setor;
import br.edu.ifsp.deposif.persistence.ISetorRepositorio;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/setor")
public class SetorController {

    private final ISetorRepositorio iSetorRepositorio;

    public SetorController(ISetorRepositorio iSetorRepositorio) {
        this.iSetorRepositorio = iSetorRepositorio;
    }

    @ModelAttribute("setor")
    public Setor setor(){
        return new Setor();
    }

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("setor", iSetorRepositorio.findAll());
        return "setor-listar";
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Model model){
        model.addAttribute("setor", new Setor());
        return "setor-cadastrar";
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@Valid Setor setor, Errors errors){
        if (errors.hasErrors()){
            log.info("Erro no cadastro de setor: {}", errors.getAllErrors());
        }

        log.info("Setor sendo cadastrado: {}", setor);
        iSetorRepositorio.save(setor);

        return "redirect:/setor/listar";
    }

}
