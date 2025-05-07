package br.edu.ifsp.deposif.model;

import lombok.Data;

@Data
public class Usuario {
    private String usuario;
    private String senha;
    private Boolean ativo;
}
