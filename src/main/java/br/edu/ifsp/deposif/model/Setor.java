package br.edu.ifsp.deposif.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "setor")
public class Setor {
    @Id
    @Column(name = "setor_id")
    private Long id;

    @NotBlank(message = "Informe a descrição")
    private String descricao;
}
