/*
 * ................
 */
package br.org.rfdouro.exemplospringrestapi02.controle;

import br.org.rfdouro.exemplospringrestapi02.modelo.Pessoa;
import br.org.rfdouro.exemplospringrestapi02.persistencia.PessoaRepositorio;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author romulo.douro
 */
// cria um controle do tipo REST que, por padrão, indica que seus endpoints
// devem receber e retornar JSON
@RestController
// aponta o caminho do recurso
@RequestMapping("/api/v1")
public class PessoaController {

 // injeta um objeto do tipo PessoaRepositorio para manipular as entidades que
 // devem ser tratadas
 @Autowired
 private PessoaRepositorio repositorio;

 // mapeamento GET para retornar um JSON com todas as pessoas ordenadas por nome
 @GetMapping("/pessoas")
 public List<Pessoa> getPessoas() {
  return repositorio.findAllByOrderByNome();
 }

 // mapeamento GET que busca todas as pessoas com um determinado nome
 @GetMapping("/pessoas/nome/{nome}")
 public List<Pessoa> getPessoas(@PathVariable(name = "nome") String nome) {
  // o segundo argumento indica que a lista será ordenada por nome
  return repositorio.findByNome(nome, Sort.by("nome"));
 }

 // mapeamento GET que recbe um ID no caminho da requisição e retorna a pesoa que
 // possui aquele ID
 @GetMapping("/pessoas/{id}")
 public ResponseEntity<Pessoa> getPessoasById(@PathVariable(value = "id") Long pessoaId) throws Exception {
  Pessoa pessoa = repositorio
    .findById(pessoaId)
    // caso não seja encontrada sera gerada uma exceção
    .orElseThrow(() -> new Exception("Pessoa not found on :: " + pessoaId));

  return ResponseEntity.ok().body(pessoa);
 }

 // mapeamento GET que recebe um parâmetro chamado nome e insere uma pessoa no
 // banco com aquele nome
 @GetMapping("/pessoas/add")
 public Pessoa createPessoa(@RequestParam(name = "nome") String nome) {
  Pessoa pessoa = new Pessoa();
  pessoa.setNome(nome);
  return repositorio.save(pessoa);
 }

 // mapeamento POST que recebe um JSON representando uma pessoa e a insere no
 // banco
 @PostMapping("/pessoas")
 public Pessoa createPessoa(@Valid @RequestBody Pessoa pessoa) {
  return repositorio.save(pessoa);
 }

 // método que recebe um ID no caminho da url e exclui a entidade
 @GetMapping("/pessoas/delete/{id}")
 public ResponseEntity<Pessoa> deletePessoaById(@PathVariable(value = "id") Long pessoaId) throws Exception {
  Pessoa pessoa = repositorio
    .findById(pessoaId)
    // caso não seja encontrada sera gerada uma exceção
    .orElseThrow(() -> new Exception("Pessoa not found on :: " + pessoaId));
  // exclui a pessoa
  repositorio.delete(pessoa);

  return ResponseEntity.ok().body(pessoa);
 }

}
