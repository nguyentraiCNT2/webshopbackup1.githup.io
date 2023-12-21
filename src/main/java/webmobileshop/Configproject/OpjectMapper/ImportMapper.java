package webmobileshop.Configproject.OpjectMapper;

import org.springframework.stereotype.Component;

import org.modelmapper.ModelMapper;
import webmobileshop.dto.ImportDTO;
import webmobileshop.entity.ImportEntity;

@Component
public class ImportMapper {
    private final CategoryMapper categoryMapper;
    private final CategoryItemMapper categoryItemMapper;
    private final ModelMapper modelMapper;

    public ImportMapper(CategoryMapper categoryMapper, CategoryItemMapper categoryItemMapper,ModelMapper modelMapper) {
        this.categoryMapper = categoryMapper;
        this.categoryItemMapper = categoryItemMapper;
        this.modelMapper = modelMapper;
    }

    public ImportDTO toDTO(ImportEntity entity) {
        ImportDTO dto = new ImportDTO();
        dto.setImportId(entity.getImportId());
        dto.setDateAdded(entity.getDateAdded());
        dto.setCategoryid(entity.getCategoryid().getCategoryId());
        dto.setCategoryItemId(entity.getCategoryItemId().getCategoryItemId());
        return dto;
    }

    public ImportEntity toEntity(ImportDTO dto) {
        ImportEntity entity = new ImportEntity();
        entity.setImportId(dto.getImportId());
        entity.setDateAdded(dto.getDateAdded());
        // Assuming you have a method in your service to find CategoryEntity by categoryId
        // and set it to ImportEntity using setCategoryid() method.
        // entity.setCategoryid(categoryService.findCategoryById(dto.getCategory().getCategoryId()));
        // Assuming you have a method in your service to find CategoryItemEntity by categoryItemId
        // and set it to ImportEntity using setCategoryItemId() method.
        // entity.setCategoryItemId(categoryItemService.findCategoryItemById(dto.getCategoryItem().getCategoryItemId()));
        return entity;
    }
}
