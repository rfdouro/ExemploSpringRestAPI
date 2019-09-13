/*
 * ................
 */
package br.org.rfdouro.exemplospringrestapi02.persistencia;

import br.org.rfdouro.exemplospringrestapi02.modelo.Pessoa;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author romulo.douro
 */
@Repository
public interface PessoaRepositorio extends JpaRepository<Pessoa, Long> {
 List<Pessoa> findByNome(String nome);
 List<Pessoa> findAllByOrderByNome();
}
