package webmobileshop.Configproject.OpjectMapper;


import org.springframework.stereotype.Component;

import org.modelmapper.ModelMapper;
import webmobileshop.dto.ProductDTO;
import webmobileshop.entity.ProductsEntity;

@Component
public class ProductsMapper {
    private final ImagesMapper imagesMapper; // Assuming you have an ImagesMapper
    private final VideoMaper videoMapper; // Assuming you have a VideoMapper
    private final CategoryItemMapper categoryItemMapper; // Assuming you have a CategoryItemMapper
    private final CategoryMapper categoryMapper; // Assuming you have a CategoryMapper
    private final CorlorMapper colorMapper; // Assuming you have a ColorMapper
    private final SizeMapper sizeMapper; // Assuming you have a SizeMapper
	  private final ModelMapper modelMapper;
    public ProductsMapper(ImagesMapper imagesMapper, VideoMaper videoMapper, CategoryItemMapper categoryItemMapper,
                          CategoryMapper categoryMapper, CorlorMapper colorMapper, SizeMapper sizeMapper,ModelMapper modelMapper) {
        this.imagesMapper = imagesMapper;
        this.videoMapper = videoMapper;
        this.categoryItemMapper = categoryItemMapper;
        this.categoryMapper = categoryMapper;
        this.colorMapper = colorMapper;
        this.sizeMapper = sizeMapper;
        this.modelMapper = modelMapper;
    }

    public ProductDTO toDTO(ProductsEntity entity) {
        ProductDTO dto = new ProductDTO();
        dto.setProductId(entity.getProductId());
        dto.setProductcore(entity.getProductcore());
        dto.setProductName(entity.getProductName());
        dto.setImagesId(entity.getImagesId() != null ? entity.getImagesId().getImagesId() : null);
        dto.setVideoId(entity.getVideoId() != null ? entity.getVideoId().getVideoId() : null);
        dto.setCategoryItemId(entity.getCategoryItemId() != null ? entity.getCategoryItemId().getCategoryItemId() : null);
        dto.setCategoryId(entity.getCategoryId() != null ? entity.getCategoryId().getCategoryId() : null);
        dto.setCorlorId(entity.getCorlorId() != null ? entity.getCorlorId().getCorlorId() : null);
        dto.setSizeId(entity.getSizeId() != null ? entity.getSizeId().getSizeId() : null);
        dto.setProductPrice(entity.getProductPrice());
        dto.setProductDescribe(entity.getProductDescribe());
        dto.setQuantityinstock(entity.getQuantityinstock());
        dto.setDateAdded(entity.getDateAdded());
        dto.setProductView(entity.getProductView());
        dto.setShowOrHidden(entity.isShowOrHidden());
        return dto;
    }

    public ProductsEntity toEntity(ProductDTO dto) {
        ProductsEntity entity = new ProductsEntity();
        entity.setProductId(dto.getProductId());
        entity.setProductcore(dto.getProductcore());
        entity.setProductName(dto.getProductName());
        entity.setProductPrice(dto.getProductPrice());
        entity.setProductDescribe(dto.getProductDescribe());
        entity.setQuantityinstock(dto.getQuantityinstock());
        entity.setDateAdded(dto.getDateAdded());
        entity.setProductView(dto.getProductView());
        entity.setShowOrHidden(dto.isShowOrHidden());
        return entity;
    }
}
