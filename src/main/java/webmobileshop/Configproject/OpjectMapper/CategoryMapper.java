package webmobileshop.Configproject.OpjectMapper;


import org.springframework.stereotype.Component;

import org.modelmapper.ModelMapper;
import webmobileshop.dto.CategoryDTO;
import webmobileshop.entity.CtegoryEntity;

@Component
public class CategoryMapper {
	
	  private final ModelMapper modelMapper;
		
	    public CategoryMapper(ModelMapper modelMapper) {
			this.modelMapper = modelMapper;
		}
    public CategoryDTO toDTO(CtegoryEntity entity) {
        CategoryDTO dto = new CategoryDTO();
        dto.setCategoryId(entity.getCategoryId());
        dto.setCategoryName(entity.getCategoryName());
        return dto;
    }

    public CtegoryEntity toEntity(CategoryDTO dto) {
        CtegoryEntity entity = new CtegoryEntity();
        entity.setCategoryId(dto.getCategoryId());
        entity.setCategoryName(dto.getCategoryName());
        return entity;
    }
}
