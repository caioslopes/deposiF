package br.edu.ifsp.deposif.web;

import br.edu.ifsp.deposif.model.Produto;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @ModelAttribute("produto")
    public Produto produto(){
        return new Produto();
    }


    public String listagem(Model model){
        return "produto-listagem";
    }

    @GetMapping("/cadastrar")
    public String cadastro(){
        return "produto-cadastrar";
    }

    @PostMapping("/cadastrar")
    public String cadastro(@Valid Produto produto, @RequestParam("setorId") Long setorId, Errors  errors){
        if (errors.hasErrors())
            log.info("Erro no cadastro de produto: {}", errors.getAllErrors());

//        setorRepo.findById(setorId).ifPresent(produto :: setSetor);

        log.info("Produto sendo cadastrado: {}", produto);

//        produtorRepo.save(produto);

        return "produto-listagem";
    }
}
