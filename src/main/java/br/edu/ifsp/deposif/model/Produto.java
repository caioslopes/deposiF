package br.edu.ifsp.deposif.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @Column(name = "produto_id")
    private Long id;

    @NotBlank(message = "Informe a descrição.")
    private String descricao;

    @NotBlank(message = "Informe a descrição técnica.")
    private String descricaoTecnica;

    @NotNull(message = "Informe a quantidade.")
    private int quantidade;

    @OneToMany
    @JoinColumn(name = "setor_id")
    private Setor setor;
}
