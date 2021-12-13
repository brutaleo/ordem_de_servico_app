package br.com.shift.modelo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
