package br.com.shift.modelo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "posto_coleta")
public class PostoColeta extends PanacheEntity {

    private String descricao;

    private String endereco;

}
