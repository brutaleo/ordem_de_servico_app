package br.com.shift.modelo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "medico")
public class Medico extends PanacheEntity {

    private String nome;

    private String especialidade;

}
