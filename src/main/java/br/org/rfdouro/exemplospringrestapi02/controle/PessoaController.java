/*
 * ................
 */
package br.org.rfdouro.exemplospringrestapi02.controle;

import br.org.rfdouro.exemplospringrestapi02.modelo.Pessoa;
import br.org.rfdouro.exemplospringrestapi02.persistencia.PessoaRepositorio;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
@RequestMapping("/api/v1")
public class PessoaController {

 @Autowired
 private PessoaRepositorio repositorio;

 @GetMapping("/pessoas")
 public List<Pessoa> getPessoas() {
  return repositorio.findAll();
 }

 @GetMapping("/pessoas/{id}")
 public ResponseEntity<Pessoa> getPessoasById(@PathVariable(value = "id") Long pessoaId) throws Exception {
  Pessoa pessoa = repositorio
          .findById(pessoaId)
          .orElseThrow(() -> new Exception("Pessoa not found on :: " + pessoaId));

  return ResponseEntity.ok().body(pessoa);
 }

 @GetMapping("/pessoas/add")
 public Pessoa createPessoa(@RequestParam(name = "nome") String nome) {
  Pessoa pessoa = new Pessoa();
  pessoa.setNome(nome);
  return repositorio.save(pessoa);
 }

 @PostMapping("/pessoas")
 public Pessoa createPessoa(@Valid @RequestBody Pessoa pessoa) {
  return repositorio.save(pessoa);
 }

}
