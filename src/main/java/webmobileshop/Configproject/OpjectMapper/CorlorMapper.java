package webmobileshop.Configproject.OpjectMapper;

import org.springframework.stereotype.Component;

import org.modelmapper.ModelMapper;
import webmobileshop.dto.CorlorDTO;
import webmobileshop.entity.CorlorEntity;

@Component
public class CorlorMapper {
	  private final ModelMapper modelMapper;
		
	    public CorlorMapper(ModelMapper modelMapper) {
			this.modelMapper = modelMapper;
		}
    public CorlorDTO toDTO(CorlorEntity entity) {
        CorlorDTO dto = new CorlorDTO();
        dto.setCorlorId(entity.getCorlorId());
        dto.setCorlorName(entity.getCorlorName());
        dto.setCorlorCore(entity.getCorlorCore());
        return dto;
    }

    public CorlorEntity toEntity(CorlorDTO dto) {
        CorlorEntity entity = new CorlorEntity();
        entity.setCorlorId(dto.getCorlorId());
        entity.setCorlorName(dto.getCorlorName());
        entity.setCorlorCore(dto.getCorlorCore());
        return entity;
    }
}
