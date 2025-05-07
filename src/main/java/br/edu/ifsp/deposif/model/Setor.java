package br.edu.ifsp.deposif.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;

import java.util.Set;

@Data
@Entity
@Table(name = "setor")
@ToString(exclude = "produtos")
public class Setor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "setor_id")
    private Long id;

    @NotBlank(message = "Informe a descrição.")
    private String descricao;

    @OneToMany
    @JoinColumn(name = "produto_id")
    private Set<Produto> produtos;
}
