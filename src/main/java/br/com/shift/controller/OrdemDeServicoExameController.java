package br.com.shift.controller;

import br.com.shift.dto.ExameDTO;
import br.com.shift.dto.ExameMapper;
import br.com.shift.model.Exame;
import br.com.shift.model.OrdemDeServicoExame;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Path("exames")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrdemDeServicoExameController {

    @Inject
    ExameMapper exameMapper;

    @GET
    @Path("{ordem_de_servico_id}")
    public List<ExameDTO> buscarExamesPorOrdemdeServico(@PathParam("ordem_de_servico_id") Long ordem_id) {
        Optional<OrdemDeServicoExame> OrdemOptional = OrdemDeServicoExame.findByIdOptional(ordem_id);
        if (OrdemOptional.isEmpty()) {
            throw new NotFoundException();
        }
        Stream<Exame> exames = Exame.stream("ordemDeServicoExame", OrdemOptional.get());
        return exames.map(e -> exameMapper.toExameDTO(e)).collect(Collectors.toList());
    }
}
