package br.edu.ifsp.deposif.persistence;

import br.edu.ifsp.deposif.model.Produto;
import org.springframework.data.repository.CrudRepository;

public interface IProdutoRepositorio extends CrudRepository<Produto, Long> {
}
