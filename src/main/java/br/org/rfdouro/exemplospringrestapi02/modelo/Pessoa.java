/*
 * ................
 */
package br.org.rfdouro.exemplospringrestapi02.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author romulo.douro
 */
@Entity
@Table(name = "pessoas")
@EntityListeners(AuditingEntityListener.class)
public class Pessoa implements Serializable {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private long id;
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
