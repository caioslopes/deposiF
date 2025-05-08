package br.edu.ifsp.deposif.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "produto")
@ToString(exclude = "setor")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produto_id")
    private Long id;

    @NotBlank(message = "Informe a descrição.")
    private String descricao;

    @NotBlank(message = "Informe a descrição técnica.")
    private String descricaoTecnica;

    @NotNull(message = "Informe a quantidade.")
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "id")
    private Setor setor;
}
