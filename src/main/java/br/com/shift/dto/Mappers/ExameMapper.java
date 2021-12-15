package br.com.shift.dto.Mappers;

import br.com.shift.dto.ExameDTO;
import br.com.shift.model.Exame;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "cdi")
public interface ExameMapper {

    ExameDTO toExameDTO(Exame e);
    Exame toExame(ExameDTO dto);

    default List<ExameDTO> toExameList(List<Exame> list) {
        return list.stream().map(this::toExameDTO).collect(Collectors.toList());
    }

}
