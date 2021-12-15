package br.com.shift.controller;

import br.com.shift.dto.AdicionarOrdemDeServicoDTO;
import br.com.shift.dto.AtualizarOrdemDeServicoDTO;
import br.com.shift.dto.OrdemDeServicoDTO;
import br.com.shift.dto.Mappers.OrdemDeServicoMapper;
import br.com.shift.model.Exame;
import br.com.shift.model.OrdemDeServico;
import br.com.shift.model.OrdemDeServicoExame;
import br.com.shift.repository.OrdemDeServicoExameRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Path("ordens")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrdemDeServicoController {

    @Inject
    OrdemDeServicoMapper ordemDeServicoMapper;
    @Inject
    OrdemDeServicoExameRepository ordemDeServicoExameRepository;

    @GET
    public List<OrdemDeServicoDTO> buscarTodasAsOrdensDeServico() {
        Stream<OrdemDeServico> ordemDeServicos = OrdemDeServico.streamAll();
        return ordemDeServicos
                .map(o -> ordemDeServicoMapper.toOrdemDeServicoDTO(o)).collect(Collectors.toList());
    }

    @POST
    @Transactional
    public Response adicionarNovaOrdemDeServico(AdicionarOrdemDeServicoDTO dto) {
        OrdemDeServico ordemDeServico = ordemDeServicoMapper.toOrdemDeServico(dto);
        ordemDeServico.persist();
        return Response.status(Response.Status.CREATED).build();
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

    @PUT
    @Path("{id}")
    @Transactional
    public void atualizarOrdemDeServico(@PathParam("id") Long id, AtualizarOrdemDeServicoDTO dto) {
        Optional<OrdemDeServico> ordemDeServicoOpitional =
                OrdemDeServico.findByIdOptional(id);
        if (ordemDeServicoOpitional.isEmpty()) {
            throw new NotFoundException();
        }
        OrdemDeServico ordemDeServico = ordemDeServicoOpitional.get();
        ordemDeServicoMapper.toOrdemDeServico(dto, ordemDeServico);
        ordemDeServico.persist();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void deletarOrdemDeServico(@PathParam("id") Long id, AdicionarOrdemDeServicoDTO dto) {
        Optional<OrdemDeServico> ordemDeServicoOpitional =
                OrdemDeServico.findByIdOptional(id);
        ordemDeServicoOpitional.ifPresentOrElse(OrdemDeServico::delete,
                () -> {
                    throw new NotFoundException();
                });
    }
}


