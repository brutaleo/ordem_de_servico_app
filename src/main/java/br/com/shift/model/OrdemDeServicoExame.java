package br.com.shift.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "ordem_de_servico_exame")
public class OrdemDeServicoExame extends PanacheEntity {

    public BigDecimal preco;

    @OneToOne(optional = false)
    public OrdemDeServico ordemDeServico;

    @OneToOne(optional = false)
    public Exame exame;

}
