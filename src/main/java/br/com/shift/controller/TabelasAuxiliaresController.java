package br.com.shift.controller;

import br.com.shift.dto.Mappers.MedicoMapper;
import br.com.shift.dto.Mappers.PacienteMapper;
import br.com.shift.dto.Mappers.PostoColetaMapper;
import br.com.shift.dto.MedicoDTO;
import br.com.shift.dto.OrdemDeServicoDTO;
import br.com.shift.dto.PacienteDTO;
import br.com.shift.dto.PostoColetaDTO;
import br.com.shift.model.Medico;
import br.com.shift.model.OrdemDeServico;
import br.com.shift.model.Paciente;
import br.com.shift.model.PostoColeta;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Path("aux")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TabelasAuxiliaresController {

    @Inject
    MedicoMapper medicoMapper;
    @Inject
    PacienteMapper pacienteMapper;
    @Inject
    PostoColetaMapper postoColetaMapper;

    @GET
    @Path("/medicos")
    public List<MedicoDTO> buscarTodosOsMedicos() {
        Stream<Medico> medico = Medico.streamAll();
        return medico
                .map(m -> medicoMapper.toMedicoDTO(m)).collect(Collectors.toList());
    }

    @GET
    @Path("/pacientes")
    public List<PacienteDTO> buscarTodosOsPacientes() {
        Stream<Paciente> paciente = Paciente.streamAll();
        return paciente
                .map(p -> pacienteMapper.toPacienteDTO(p)).collect(Collectors.toList());
    }

    @GET
    @Path("/postos")
    public List<PostoColetaDTO> buscarTodosOsPostosDeColeta() {
        Stream<PostoColeta> postoColeta = PostoColeta.streamAll();
        return postoColeta
                .map(pc -> postoColetaMapper.toPostoColetaDTO(pc)).collect(Collectors.toList());
    }
}
