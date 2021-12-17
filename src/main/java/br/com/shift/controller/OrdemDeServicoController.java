package br.com.shift.controller;

import br.com.shift.dto.AdicionarOrdemDeServicoDTO;
import br.com.shift.dto.AtualizarOrdemDeServicoDTO;
import br.com.shift.dto.Mappers.OrdemDeServicoMapper;
import br.com.shift.dto.OrdemDeServicoDTO;
import br.com.shift.model.OrdemDeServico;

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
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Path("ordens")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrdemDeServicoController {

    @Inject
    OrdemDeServicoMapper ordemDeServicoMapper;

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



    @PUT
    @Path("protocolo/{id}")
    @Transactional
    public void gerarProtocoloDaOrdemDeServico(@PathParam("id") Long id) {
        Optional<OrdemDeServico> ordemDeServicoOpitional =
                OrdemDeServico.findByIdOptional(id);
        if (ordemDeServicoOpitional.isEmpty()) {
            throw new NotFoundException();
        }
        OrdemDeServico ordemDeServico = ordemDeServicoOpitional.get();
        ordemDeServico.protocolo = gerarNumeroDeprotocolo();
        ordemDeServico.persist();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void deletarOrdemDeServico(@PathParam("id") Long id) {
        Optional<OrdemDeServico> ordemDeServicoOpitional =
                OrdemDeServico.findByIdOptional(id);
        ordemDeServicoOpitional.ifPresentOrElse(OrdemDeServico::delete,
                () -> {
                    throw new NotFoundException();
                });
    }

    private String gerarNumeroDeprotocolo() {

        Random ran = new Random();
        int top = 9;
        char data = ' ';
        StringBuilder dat = new StringBuilder();

        for (int i=0; i<=top; i++) {
            data = (char)(ran.nextInt(25)+97);
            dat.insert(0, data);
        }

        return dat.toString().toUpperCase();
    }
}


