package webmobileshop.Configproject.OpjectMapper;

import org.springframework.stereotype.Component;

import org.modelmapper.ModelMapper;
import webmobileshop.dto.ImagesDTO;
import webmobileshop.dto.RoleDTO;
import webmobileshop.entity.ImagesEntity;
import webmobileshop.entity.RoleEntity;

@Component
public class ImagesMapper {

	  private final ModelMapper modelMapper;
		
	    public ImagesMapper(ModelMapper modelMapper) {
			this.modelMapper = modelMapper;
		}
	    
	    public ImagesDTO mapToDTO(ImagesEntity entity) {
	    	ImagesDTO dto =  modelMapper.map(entity, ImagesDTO.class);
	        return dto;
	    }
	    
	    public ImagesEntity mapToEntity(ImagesDTO dto) {
	    	ImagesEntity entity =  modelMapper.map(dto, ImagesEntity.class);
	        return entity;
	    }
    public ImagesDTO toDTO(ImagesEntity entity) {
        ImagesDTO dto = new ImagesDTO();
        dto.setImagesId(entity.getImagesId());
        dto.setName(entity.getName());
        dto.setShowOrHidden(entity.isShowOrHidden());
        return dto;
    }

    public ImagesEntity toEntity(ImagesDTO dto) {
        ImagesEntity entity = new ImagesEntity();
        entity.setImagesId(dto.getImagesId());
        entity.setName(dto.getName());
        entity.setShowOrHidden(dto.isShowOrHidden());
        return entity;
    }
}
