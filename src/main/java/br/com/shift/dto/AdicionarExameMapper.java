package br.com.shift.dto;

import br.com.shift.model.OrdemDeServico;
import br.com.shift.model.OrdemDeServicoExame;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "cdi")
public interface AdicionarExameMapper {

    AdicionarExameDTO toAdicionarExameDTO(OrdemDeServico o);
    OrdemDeServicoExame toAdicionarExame(AdicionarExameDTO dto);

}
