package br.com.shift.dto.Mappers;

import br.com.shift.dto.PacienteDTO;
import br.com.shift.dto.PostoColetaDTO;
import br.com.shift.model.Paciente;
import br.com.shift.model.PostoColeta;
import org.jboss.logging.annotations.Pos;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "cdi")
public interface PostoColetaMapper {

    PostoColetaDTO toPostoColetaDTO(PostoColeta pc);
    PostoColeta toPostoColeta(PostoColetaDTO dto);

    default List<PostoColetaDTO> toPostoColetaList(List<PostoColeta> list) {
        return list.stream().map(this::toPostoColetaDTO).collect(Collectors.toList());
    }

}
