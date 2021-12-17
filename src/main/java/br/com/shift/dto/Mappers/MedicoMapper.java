package br.com.shift.dto.Mappers;

import br.com.shift.dto.MedicoDTO;
import br.com.shift.model.Medico;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "cdi")
public interface MedicoMapper {

    MedicoDTO toMedicoDTO(Medico m);
    Medico toMedico(MedicoDTO dto);

    default List<MedicoDTO> toMedicoList(List<Medico> list) {
        return list.stream().map(this::toMedicoDTO).collect(Collectors.toList());
    }

}
