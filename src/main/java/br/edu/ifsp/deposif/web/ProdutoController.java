package br.edu.ifsp.deposif.web;

import br.edu.ifsp.deposif.persistence.IProdutoRepositorio;
import br.edu.ifsp.deposif.model.Produto;
import br.edu.ifsp.deposif.persistence.ISetorRepositorio;
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

    private final IProdutoRepositorio iProdutoRepositorio;
    private final ISetorRepositorio iSetorRepositorio;

    public ProdutoController(IProdutoRepositorio iProdutoRepositorio, ISetorRepositorio iSetorRepositorio) {
        this.iProdutoRepositorio = iProdutoRepositorio;
        this.iSetorRepositorio = iSetorRepositorio;
    }

    @ModelAttribute("produto")
    public Produto produto(){
        return new Produto();
    }

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("listaDeProdutos", iProdutoRepositorio.findAll());
        return "produto-listar";
    }

    @GetMapping("/cadastrar")
    public String cadastro(Model model){
        model.addAttribute("listaDeSetores", iSetorRepositorio.findAll());
        return "produto-cadastrar";
    }

    @PostMapping("/cadastrar")
    public String cadastro(@Valid Produto produto, @RequestParam("setorId") Long setorId, Errors  errors){
        if (errors.hasErrors())
            log.info("Erro no cadastro de produto: {}", errors.getAllErrors());

        iSetorRepositorio.findById(setorId).ifPresent(produto :: setSetor);

        log.info("Produto sendo cadastrado: {}", produto);
        iProdutoRepositorio.save(produto);

        return "redirect:/produto/listar";
    }
}
