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
        dto.setImagesId(entity.getImagesId().getImagesId()); // Assuming getImagesId() returns ImagesEntity
        dto.setVideoId(entity.getVideoId().getVideoId()); // Assuming getVideoId() returns VideoEntity
        dto.setCategoryItemId(entity.getCategoryItemId().getCategoryItemId()); // Assuming getCategoryItemId() returns CategoryItemEntity
        dto.setCategoryId(entity.getCategoryId().getCategoryId()); // Assuming getCategoryId() returns CategoryEntity
        dto.setCorlorId(entity.getCorlorId().getCorlorId()); // Assuming getCorlorId() returns ColorEntity
        dto.setSizeId(entity.getSizeId().getSizeId()); // Assuming getSizeId() returns SizeEntity
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
        // Assuming you have a method in your service to find ImagesEntity by imagesId
        // and set it to ProductsEntity using setImagesId() method.
        // entity.setImagesId(imagesService.findImagesById(dto.getImagesId()));
        // Assuming you have a method in your service to find VideoEntity by videoId
        // and set it to ProductsEntity using setVideoId() method.
        // entity.setVideoId(videoService.findVideoById(dto.getVideoId()));
        // Assuming you have a method in your service to find CategoryItemEntity by categoryItemId
        // and set it to ProductsEntity using setCategoryItemId() method.
        // entity.setCategoryItemId(categoryItemService.findCategoryItemById(dto.getCategoryItemId()));
        // Assuming you have a method in your service to find CategoryEntity by categoryId
        // and set it to ProductsEntity using setCategoryId() method.
        // entity.setCategoryId(categoryService.findCategoryById(dto.getCategoryId()));
        // Assuming you have a method in your service to find ColorEntity by colorId
        // and set it to ProductsEntity using setCorlorId() method.
        // entity.setCorlorId(colorService.findColorById(dto.getColorId()));
        // Assuming you have a method in your service to find SizeEntity by sizeId
        // and set it to ProductsEntity using setSizeId() method.
        // entity.setSizeId(sizeService.findSizeById(dto.getSizeId()));
        entity.setProductPrice(dto.getProductPrice());
        entity.setProductDescribe(dto.getProductDescribe());
        entity.setQuantityinstock(dto.getQuantityinstock());
        entity.setDateAdded(dto.getDateAdded());
        entity.setProductView(dto.getProductView());
        entity.setShowOrHidden(dto.isShowOrHidden());
        return entity;
    }
}
