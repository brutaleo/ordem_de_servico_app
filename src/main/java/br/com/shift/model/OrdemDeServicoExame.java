package br.com.shift.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "ordem_de_servico_exame")
@NamedQuery(name = "OrdemDeServicoExame.getByOrdemExame",
query = "SELECT o FROM OrdemDeServicoExame o WHERE o.ordemDeServico.id = ?1 " +
        "AND o.exame.id = ?2")
public class OrdemDeServicoExame extends PanacheEntity {

    @ManyToOne(optional = false)
    public OrdemDeServico ordemDeServico;

    @ManyToOne(optional = false)
    public Exame exame;


    public Long getExame() {
        return exame.id;
    }
}
