package br.com.shift.dto.Mappers;

import br.com.shift.dto.MedicoDTO;
import br.com.shift.dto.PacienteDTO;
import br.com.shift.model.Medico;
import br.com.shift.model.Paciente;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "cdi")
public interface PacienteMapper {

    PacienteDTO toPacienteDTO(Paciente p);
    Paciente toPaciente(PacienteDTO dto);

    default List<PacienteDTO> toPacienteList(List<Paciente> list) {
        return list.stream().map(this::toPacienteDTO).collect(Collectors.toList());
    }

}
