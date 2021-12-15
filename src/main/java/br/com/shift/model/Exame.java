package br.com.shift.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "exame")
public class Exame extends PanacheEntity {

    public String descricao;

    public BigDecimal preco;

}
