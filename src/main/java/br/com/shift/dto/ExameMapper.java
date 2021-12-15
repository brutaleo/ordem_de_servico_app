package br.com.shift.dto;

import br.com.shift.model.Exame;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface ExameMapper {

    ExameDTO toExameDTO(Exame e);
    Exame toExame(ExameDTO dto);

}
