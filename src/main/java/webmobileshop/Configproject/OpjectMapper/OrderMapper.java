package webmobileshop.Configproject.OpjectMapper;

import org.springframework.stereotype.Component;

import org.modelmapper.ModelMapper;
import webmobileshop.dto.OrderDTO;
import webmobileshop.entity.OrderEntity;

@Component
public class OrderMapper {
    private final ProductsMapper productsMapper;
    private final UserAccountMapper userAccountMapper;
    private final GuestMapper guestMapper;

	  private final ModelMapper modelMapper;

    public OrderMapper(ProductsMapper productsMapper, UserAccountMapper userAccountMapper, GuestMapper guestMapper,ModelMapper modelMapper) {
        this.productsMapper = productsMapper;
        this.userAccountMapper = userAccountMapper;
        this.guestMapper = guestMapper;
        this.modelMapper = modelMapper;
    }

    public OrderDTO toDTO(OrderEntity entity) {
        OrderDTO dto = new OrderDTO();
        dto.setOrderId(entity.getOrderId());
        dto.setProductId(entity.getProductId().getProductId());
        dto.setUserId(entity.getUserId().getUserId());
        dto.setQuestId(entity.getGuestId().getQuestId());
        // Convert Date to String as needed
        dto.setDateBooking(entity.getDateBooking());
        dto.setDateDelivery(entity.getDateDelivery());
        dto.setCancelOrder(entity.isCancelOrder());
        return dto;
    }

    public OrderEntity toEntity(OrderDTO dto) {
        OrderEntity entity = new OrderEntity();
        entity.setOrderId(dto.getOrderId());
        // Assuming you have a method in your service to find ProductsEntity by productId
        // and set it to OrderEntity using setProductId() method.
        // entity.setProductId(productsService.findProductById(dto.getProductId()));
        // Assuming you have a method in your service to find UserAccountEntity by userId
        // and set it to OrderEntity using setUserId() method.
        // entity.setUserId(userAccountService.findUserById(dto.getUserId()));
        // Assuming you have a method in your service to find GuestEntity by guestId
        // and set it to OrderEntity using setGuestId() method.
        // entity.setGuestId(guestService.findGuestById(dto.getGuestId()));
        // Convert String to Date as needed
        // entity.setDateBooking(Date.valueOf(dto.getDateBooking()));
        // entity.setDateDelivery(Date.valueOf(dto.getDateDelivery()));
        entity.setCancelOrder(dto.isCancelOrder());
        return entity;
    }
}
