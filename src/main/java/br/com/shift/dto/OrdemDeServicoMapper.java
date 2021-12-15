package br.com.shift.dto;

import br.com.shift.model.OrdemDeServico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "cdi")
public interface OrdemDeServicoMapper {

    @Mapping(target = "dataCadastro", dateFormat = "dd/MM/yyyy")
    OrdemDeServicoDTO toOrdemDeServicoDTO(OrdemDeServico o);
    OrdemDeServico toOrdemDeServico(AdicionarOrdemDeServicoDTO dto);
    void toOrdemDeServico(AtualizarOrdemDeServicoDTO dto, @MappingTarget OrdemDeServico ordemDeServico);

}
