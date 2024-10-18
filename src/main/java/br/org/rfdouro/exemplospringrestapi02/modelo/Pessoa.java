/*
 * ................
 */
package br.org.rfdouro.exemplospringrestapi02.modelo;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author romulo.douro
 */
// representa uma entidade
@Entity
// o nome da tabela no banco de dados será 'pessoas'
@Table(name = "pessoas")
// habilita ações de auditagem para monitorar as atividades de banco para os
// registros dessa tabela - não usado, inserido apenas como exemplo
@EntityListeners(AuditingEntityListener.class)
public class Pessoa implements Serializable {
 // indica a chave primária dessa entidade
 @Id
 // o valor dessa coluna será gerado automaticamente pelo banco no momento da
 // inserção
 @GeneratedValue(strategy = GenerationType.AUTO)
 private long id;
 // aplica restrições para a coluna
 // se chamará nomePessoa, terá 150 caracteres no máxmio e não pode ser nulo
 @Column(length = 150, name = "nomePessoa", nullable = false)
 private String nome;

 public long getId() {
  return id;
 }

 public void setId(long id) {
  this.id = id;
 }

 public String getNome() {
  return nome;
 }

 public void setNome(String nome) {
  this.nome = nome;
 }

}
