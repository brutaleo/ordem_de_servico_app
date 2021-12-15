package br.com.shift.repository;

import br.com.shift.model.OrdemDeServico;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class OrdemDeServicoRepository implements PanacheRepository<OrdemDeServico> {

    public List<OrdemDeServico> buscarordemDeServicoPorProtocolo(String numeroProtocolo) {
        return find("protocolo like ?1 ", "%" + numeroProtocolo + "%").list();
    }


}
