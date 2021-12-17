package br.com.shift.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ordem_de_servico_exame")
public class OrdemDeServicoExame extends PanacheEntity {

    @ManyToOne(optional = false)
    public OrdemDeServico ordemDeServico;

    @ManyToOne(optional = false)
    public Exame exame;


    public Long getExame() {
        return exame.id;
    }
}
