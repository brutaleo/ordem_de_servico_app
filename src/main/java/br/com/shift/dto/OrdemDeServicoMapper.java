package br.com.shift.dto;

import br.com.shift.modelo.OrdemDeServico;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "cdi")
public interface OrdemDeServicoMapper {

    OrdemDeServicoDTO toOrdemDeServicoDTO(OrdemDeServico o);
    OrdemDeServico toOrdemDeServico(AdicionarOrdemDeServicoDTO dto);
    void toOrdemDeServico(AtualizarOrdemDeServicoDTO dto, @MappingTarget OrdemDeServico ordemDeServico);

}
