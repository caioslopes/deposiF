package br.edu.ifsp.deposif.model;

import lombok.Data;

@Data
public class Produto {
    private Long id;
    private String descricao;
    private String descricaoTecnica;
    private int quantidade;
    private Setor setor;
}
