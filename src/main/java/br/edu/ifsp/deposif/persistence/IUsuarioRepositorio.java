package br.edu.ifsp.deposif.persistence;

import br.edu.ifsp.deposif.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioRepositorio extends CrudRepository<Usuario, String> {
}
