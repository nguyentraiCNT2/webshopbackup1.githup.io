package webmobileshop.Configproject.OpjectMapper;


import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;
import webmobileshop.dto.OrderDetailDTO;
import webmobileshop.entity.OrderDetailEntity;

@Component
public class OrderDetailMapper {
    private final OrderMapper orderMapper;
    private final ProductsMapper productsMapper;
    private final UserAccountMapper userAccountMapper;

	  private final ModelMapper modelMapper;

    public OrderDetailMapper(OrderMapper orderMapper, ProductsMapper productsMapper, UserAccountMapper userAccountMapper,ModelMapper modelMapper) {
        this.orderMapper = orderMapper;
        this.productsMapper = productsMapper;
        this.userAccountMapper = userAccountMapper;
        this.modelMapper = modelMapper;
    }

    public OrderDetailDTO toDTO(OrderDetailEntity entity) {
        OrderDetailDTO dto = new OrderDetailDTO();
        dto.setOrderDetailId(entity.getOrderDetailId());
        dto.setOrderId(entity.getOrderId().getOrderId());
        dto.setProductId(entity.getProductId().getProductId());
        dto.setUserId(entity.getUserId().getUserId());
        dto.setProductName(entity.getProductName());
        dto.setQuantity(entity.getQuantity());
        dto.setPrice(entity.getPrice());
        return dto;
    }

    public OrderDetailEntity toEntity(OrderDetailDTO dto) {
        OrderDetailEntity entity = new OrderDetailEntity();
        entity.setOrderDetailId(dto.getOrderDetailId());
        // Assuming you have a method in your service to find OrderEntity by orderId
        // and set it to OrderDetailEntity using setOrderId() method.
        // entity.setOrderId(orderService.findOrderById(dto.getOrderId()));
        // Assuming you have a method in your service to find ProductsEntity by productId
        // and set it to OrderDetailEntity using setProductId() method.
        // entity.setProductId(productsService.findProductById(dto.getProductId()));
        // Assuming you have a method in your service to find UserAccountEntity by userId
        // and set it to OrderDetailEntity using setUserId() method.
        // entity.setUserId(userAccountService.findUserById(dto.getUserId()));
        entity.setProductName(dto.getProductName());
        entity.setQuantity(dto.getQuantity());
        entity.setPrice(dto.getPrice());
        return entity;
    }
}
