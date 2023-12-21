package webmobileshop.Configproject.OpjectMapper;

import org.springframework.stereotype.Component;

import org.modelmapper.ModelMapper;
import webmobileshop.dto.SizeDTO;
import webmobileshop.entity.SizeEntity;

@Component
public class SizeMapper {

	  private final ModelMapper modelMapper;
		
	    public SizeMapper(ModelMapper modelMapper) {
			this.modelMapper = modelMapper;
		}
    public SizeDTO toDTO(SizeEntity entity) {
        SizeDTO dto = new SizeDTO();
        dto.setSizeId(entity.getSizeId());
        dto.setSizeName(entity.getSizeName());
        return dto;
    }

    public SizeEntity toEntity(SizeDTO dto) {
        SizeEntity entity = new SizeEntity();
        entity.setSizeId(dto.getSizeId());
        entity.setSizeName(dto.getSizeName());
        return entity;
    }
}
