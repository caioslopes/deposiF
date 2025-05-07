package br.edu.ifsp.deposif.web;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/produto")
public class ProdutoController {

    public String listagem(Model model){
        return "produto-listagem";
    }

}
