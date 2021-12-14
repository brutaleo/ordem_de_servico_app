package br.com.shift.dto;

import br.com.shift.modelo.OrdemDeServico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface OrdemDeServicoMapper {
    OrdemDeServico toOrdemDeServico(OrdemDeServicoDTO dto);
    OrdemDeServicoDTO toOrdemDeServicoDTO(OrdemDeServico o);

}
