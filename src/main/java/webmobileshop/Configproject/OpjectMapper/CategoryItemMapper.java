package webmobileshop.Configproject.OpjectMapper;


import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;
import webmobileshop.dto.*;
import webmobileshop.entity.CategoryItemEntity;

@Component
public class CategoryItemMapper {
	  private final ModelMapper modelMapper;
	
    public CategoryItemMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public CategotyItemDTO toDTO(CategoryItemEntity entity) {
    	CategotyItemDTO dto = new CategotyItemDTO();
        dto.setCategoryItemId(entity.getCategoryItemId());
        dto.setCategoryItemName(entity.getCategoryItemName());
        dto.setCategoryItemLogo(entity.getCategoryItemLogo());
        return dto;
    }

    public CategoryItemEntity toEntity(CategotyItemDTO dto) {
        CategoryItemEntity entity = new CategoryItemEntity();
        entity.setCategoryItemId(dto.getCategoryItemId());
        entity.setCategoryItemName(dto.getCategoryItemName());
        entity.setCategoryItemLogo(dto.getCategoryItemLogo());
        return entity;
    }
}
