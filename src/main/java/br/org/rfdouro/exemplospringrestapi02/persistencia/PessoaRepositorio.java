/*
 * ................
 */
package br.org.rfdouro.exemplospringrestapi02.persistencia;

import br.org.rfdouro.exemplospringrestapi02.modelo.Pessoa;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author romulo.douro
 */
// objeto gerenciado que, ao ser usado, oferece a capacidade de manipulação de
// entidades do tipo Pessoa tendo métodos automatizados para salvar, excluir etc
// entidades desse tipos
@Repository
public interface PessoaRepositorio extends JpaRepository<Pessoa, Long> {
 // método customizado para buscar pessoas que tenham um determinado nome e
 // também recebe o fator de ordenação
 List<Pessoa> findByNome(String nome, Sort s);

 // método customizado para buscar todas as pessoas e mostrar com ordenação por
 // nome
 List<Pessoa> findAllByOrderByNome();
}
