package br.com.shift.controller;

import br.com.shift.dto.OrdemDeServicoDTO;
import br.com.shift.dto.OrdemDeServicoMapper;
import br.com.shift.modelo.OrdemDeServico;

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

@Path("Ordens")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrdemDeServicoController {

    @Inject
    OrdemDeServicoMapper ordemDeServicoMapper;

    @GET
    public List<OrdemDeServicoDTO> buscarTodasAsOrdensDeServico() {
        Stream<OrdemDeServico> ordemDeServico = OrdemDeServico.streamAll();
        return ordemDeServico
                .map(o -> ordemDeServicoMapper.toOrdemDeServicoDTO(o))
                .collect(Collectors.toList());
    }
    
    @POST
    @Transactional
    public void adicionarNovaOrdemDeServico(OrdemDeServicoDTO dto) {
        OrdemDeServico ordemDeServico = ordemDeServicoMapper.toOrdemDeServico(dto);
        ordemDeServico.persist();
        Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public void alterarOrdemDeServico(@PathParam("id") Long id, OrdemDeServicoDTO dto) {
        Optional<OrdemDeServico> ordemDeServicoOpitional =
                OrdemDeServico.findByIdOptional(id);
        if (ordemDeServicoOpitional.isEmpty()) {
            throw new NotFoundException();
        }
        OrdemDeServico ordemDeServico = ordemDeServicoOpitional.get();

    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void deletarOrdemDeServico(@PathParam("id") Long id, OrdemDeServicoDTO dto) {
        Optional<OrdemDeServico> ordemDeServicoOpitional =
                OrdemDeServico.findByIdOptional(id);
        ordemDeServicoOpitional.ifPresentOrElse(OrdemDeServico::delete,
                () -> {
                    throw new NotFoundException();
                });
        }
    }


