package br.edu.ifsp.deposif.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @Column(name = "produto_id")
    private Long id;

    @NotBlank(message = "Informe a descrição")
    private String descricao;

    private String descricaoTecnica;


    private int quantidade;

    @OneToMany
    @JoinColumn(name = "setor_id")
    @MapsId
    private Setor setor;
}
