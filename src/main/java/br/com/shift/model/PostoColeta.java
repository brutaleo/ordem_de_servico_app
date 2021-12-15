package br.com.shift.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "posto_coleta")
public class PostoColeta extends PanacheEntity {

    public String descricao;

    public String endereco;

}
