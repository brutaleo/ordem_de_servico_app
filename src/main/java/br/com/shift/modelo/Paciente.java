package br.com.shift.modelo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "paciente")
public class Paciente extends PanacheEntity {

    private String nome;

    private LocalDate dataNascimento;

    private String sexo;

    private String endereco;


}
