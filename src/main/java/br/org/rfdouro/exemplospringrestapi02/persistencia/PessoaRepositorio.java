/*
 * ................
 */
package br.org.rfdouro.exemplospringrestapi02.persistencia;

import br.org.rfdouro.exemplospringrestapi02.modelo.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author romulo.douro
 */
@Repository
public interface PessoaRepositorio extends JpaRepository<Pessoa, Long> {
 
}
