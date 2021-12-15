package br.com.shift.dto.Mappers;

import br.com.shift.dto.AdicionarExameDTO;
import br.com.shift.model.OrdemDeServico;
import br.com.shift.model.OrdemDeServicoExame;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface AdicionarExameMapper {

    AdicionarExameDTO toAdicionarExameDTO(OrdemDeServico o);
    OrdemDeServicoExame toAdicionarExame(AdicionarExameDTO dto);

}
