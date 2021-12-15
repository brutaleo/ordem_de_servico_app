package br.com.shift.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "paciente")
public class Paciente extends PanacheEntity {

   public String nome;

   public LocalDate dataNascimento;

   public String sexo;

   public String endereco;


}
