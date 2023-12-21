package webmobileshop.Configproject.OpjectMapper;

import org.springframework.stereotype.Component;

import org.modelmapper.ModelMapper;
import webmobileshop.dto.ReviewDTO;
import webmobileshop.entity.ReviewEntity;

@Component
public class ReviewMapper {

	  private final ModelMapper modelMapper;
		
	    public ReviewMapper(ModelMapper modelMapper) {
			this.modelMapper = modelMapper;
		}
    public ReviewDTO toDTO(ReviewEntity entity) {
        ReviewDTO dto = new ReviewDTO();
        dto.setReviewId(entity.getReviewId());
        dto.setProductId(entity.getProductId().getProductId()); // Assuming getProductId() returns ProductsEntity
        dto.setUserId(entity.getUserId().getUserId()); // Assuming getUserId() returns UserAccountEntity
        dto.setContent(entity.getContent());
        dto.setReviewStar(entity.getReviewStar());
        dto.setStatus(entity.isStatus());
        return dto;
    }

    public ReviewEntity toEntity(ReviewDTO dto) {
        ReviewEntity entity = new ReviewEntity();
        entity.setReviewId(dto.getReviewId());
        // Assuming you have a method in your service to find ProductsEntity by productId
        // and set it to ReviewEntity using setProductId() method.
        // entity.setProductId(productsService.findProductById(dto.getProductId()));
        // Assuming you have a method in your service to find UserAccountEntity by userId
        // and set it to ReviewEntity using setUserId() method.
        // entity.setUserId(userService.findUserById(dto.getUserId()));
        entity.setContent(dto.getContent());
        entity.setReviewStar(dto.getReviewStar());
        entity.setStatus(dto.isStatus());
        return entity;
    }
}
