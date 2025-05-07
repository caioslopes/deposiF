package br.edu.ifsp.deposif.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    private String usuario;

    @NotBlank(message = "Informe a senha")
    private String senha;

    private Boolean ativo;
}
