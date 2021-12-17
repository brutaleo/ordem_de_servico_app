package br.com.shift.controller;

import br.com.shift.dto.ExameDTO;
import br.com.shift.dto.Mappers.ExameMapper;
import br.com.shift.model.Exame;
import br.com.shift.model.OrdemDeServico;
import br.com.shift.model.OrdemDeServicoExame;
import br.com.shift.repository.OrdemDeServicoExameRepository;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path("exames")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrdemDeServicoExameController {

    @Inject
    ExameMapper exameMapper;
    @Inject
    OrdemDeServicoExameRepository ordemDeServicoExameRepository;

    @GET
    @Path("{ordem_de_servico_id}")
    public List<ExameDTO> listarExames(@PathParam("ordem_de_servico_id") Long ordem_id) {

        List<OrdemDeServicoExame> ordemDeServicoExames =
                ordemDeServicoExameRepository.buscarExamesCadastradosNaOrdemDeServico(ordem_id);

        List<Exame> exames = new ArrayList<>();

        ordemDeServicoExames.forEach(ordemExame -> {
            exames.add(Exame.findById(ordemExame.getExame()));
        });

        return exameMapper.toExameList(exames);
    }

    @POST
    @Path("{ordem_id}/{exame_id}")
    @Transactional
    public Response adicionaExameNaOrdemDeServico(@PathParam("ordem_id") Long ordem_id, @PathParam("exame_id") Long exame_id) {

        Optional<OrdemDeServico> ordemOptional = OrdemDeServico.findByIdOptional(ordem_id);
        if (ordemOptional.isEmpty()) {
            throw new NotFoundException();
        }

        Optional<Exame> exameOptional = Exame.findByIdOptional(exame_id);
        if (exameOptional.isEmpty()) {
            throw new NotFoundException();
        }

        OrdemDeServicoExame ordemDeServicoExame = new OrdemDeServicoExame();
        ordemDeServicoExame.ordemDeServico = ordemOptional.get();
        ordemDeServicoExame.exame = exameOptional.get();

        ordemDeServicoExameRepository.persist(ordemDeServicoExame);

        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("{ordem_id}/{exame_id}")
    @Transactional
    public void deletarOrdemDeServico(@PathParam("ordem_id") Long ordem_id, @PathParam("exame_id") Long exame_id) {

        PanacheQuery<OrdemDeServicoExame> ordemExameQuery = ordemDeServicoExameRepository
                .find("#OrdemDeServicoExame.getByOrdemExame", ordem_id, exame_id);

        OrdemDeServicoExame ordemDeServicoExame = ordemExameQuery.firstResult();
        if (ordemDeServicoExame != null) {
            ordemDeServicoExameRepository.delete(ordemDeServicoExame);
        }

    }
}
