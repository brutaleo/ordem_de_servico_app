package br.com.shift.controller;

import br.com.shift.dto.ExameDTO;
import br.com.shift.dto.Mappers.ExameMapper;
import br.com.shift.model.Exame;
import br.com.shift.model.OrdemDeServicoExame;
import br.com.shift.repository.OrdemDeServicoExameRepository;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

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

        for (OrdemDeServicoExame ordemDeServicoExame : ordemDeServicoExames) {
            exames.add(Exame.findById(ordemDeServicoExame.exame));
        }
        return exameMapper.toExameList(exames);

    }
}
