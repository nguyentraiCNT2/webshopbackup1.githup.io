package webmobileshop.Configproject.OpjectMapper;

import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;
import webmobileshop.dto.ShoppingCartDTO;
import webmobileshop.entity.ShoppingCartEntity;

@Component
public class ShoppingCartMapper {

	  private final ModelMapper modelMapper;
		
	    public ShoppingCartMapper(ModelMapper modelMapper) {
			this.modelMapper = modelMapper;
		}
    public ShoppingCartDTO toDTO(ShoppingCartEntity entity) {
        ShoppingCartDTO dto = new ShoppingCartDTO();
        dto.setShoppingCartId(entity.getShoppingCartId());
        dto.setUserId(entity.getUserId().getUserId()); // Assuming getUserId() returns UserAccountEntity
        dto.setProductId(entity.getProductId().getProductId()); // Assuming getProductId() returns ProductsEntity
        dto.setQuantity(entity.getQuantity());
        dto.setShippingPrice(entity.getShippingPrice());
        dto.setTotalAmount(entity.getTotalAmount());
        dto.setExtraDay(entity.getExtraDay());
        return dto;
    }

    public ShoppingCartEntity toEntity(ShoppingCartDTO dto) {
        ShoppingCartEntity entity = new ShoppingCartEntity();
        entity.setShoppingCartId(dto.getShoppingCartId());
        // Assuming you have a method in your service to find UserAccountEntity by userId
        // and set it to ShoppingCartEntity using setUserId() method.
        // entity.setUserId(userService.findUserById(dto.getUserId()));
        // Assuming you have a method in your service to find ProductsEntity by productId
        // and set it to ShoppingCartEntity using setProductId() method.
        // entity.setProductId(productsService.findProductById(dto.getProductId()));
        entity.setQuantity(dto.getQuantity());
        entity.setShippingPrice(dto.getShippingPrice());
        entity.setTotalAmount(dto.getTotalAmount());
        entity.setExtraDay(dto.getExtraDay());
        return entity;
    }
}
