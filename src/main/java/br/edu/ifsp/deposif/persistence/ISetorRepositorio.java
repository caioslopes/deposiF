package br.edu.ifsp.deposif.persistence;

import br.edu.ifsp.deposif.model.Setor;
import org.springframework.data.repository.CrudRepository;

public interface ISetorRepositorio extends CrudRepository<Setor, Long> {
}
