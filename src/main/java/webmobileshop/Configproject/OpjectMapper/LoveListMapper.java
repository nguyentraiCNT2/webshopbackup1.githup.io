package webmobileshop.Configproject.OpjectMapper;

import org.springframework.stereotype.Component;

import org.modelmapper.ModelMapper;
import webmobileshop.dto.LoveListDTO;
import webmobileshop.entity.LoveListEntity;

@Component
public class LoveListMapper {
    private final UserAccountMapper userAccountMapper;
    private final ProductsMapper productsMapper;
    private final ModelMapper modelMapper;

    public LoveListMapper(UserAccountMapper userAccountMapper, ProductsMapper productsMapper,ModelMapper modelMapper) {
        this.userAccountMapper = userAccountMapper;
        this.productsMapper = productsMapper;
        this.modelMapper = modelMapper;
    }

    public LoveListDTO toDTO(LoveListEntity entity) {
        LoveListDTO dto = new LoveListDTO();
        dto.setLoveListId(entity.getLoveListId());
        dto.setLoveListName(entity.getLoveListName());
        dto.setUserId(entity.getUserId().getUserId());
        dto.setProductId(entity.getProductId().getProductId());
        dto.setStatus(entity.isStatus());
        return dto;
    }

    public LoveListEntity toEntity(LoveListDTO dto) {
        LoveListEntity entity = new LoveListEntity();
        entity.setLoveListId(dto.getLoveListId());
        entity.setLoveListName(dto.getLoveListName());
        // Assuming you have a method in your service to find UserAccountEntity by userId
        // and set it to LoveListEntity using setUserId() method.
        // entity.setUserId(userAccountService.findUserById(dto.getUserId()));
        // Assuming you have a method in your service to find ProductsEntity by productId
        // and set it to LoveListEntity using setProductId() method.
        // entity.setProductId(productsService.findProductById(dto.getProductId()));
        entity.setStatus(dto.isStatus());
        return entity;
    }
}
