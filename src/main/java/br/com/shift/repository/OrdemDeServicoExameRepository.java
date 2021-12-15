package br.com.shift.repository;

import br.com.shift.model.OrdemDeServico;
import br.com.shift.model.OrdemDeServicoExame;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class OrdemDeServicoExameRepository implements PanacheRepository<OrdemDeServicoExame> {



}
