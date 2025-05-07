package br.edu.ifsp.deposif.web;

import br.edu.ifsp.deposif.model.Setor;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/setor")
public class SetorController {

    @ModelAttribute("setor")
    public Setor setor(){
        return new Setor();
    }

    @GetMapping("/cadastrar")
    public String cadastrar(){
        return "setor-cadastrar";
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@Valid Setor setor, Errors errors){
        if (errors.hasErrors())
            log.info("Erro no cadastro de setor: {}", errors.getAllErrors());

        log.info("Setor sendo cadastrado: {}", setor);
//        setorRepo.save(setor);

        return "setor-cadastrar";
    }



}
