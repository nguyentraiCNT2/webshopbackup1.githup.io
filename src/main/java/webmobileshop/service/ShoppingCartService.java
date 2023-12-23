package webmobileshop.service;

import org.springframework.data.domain.Pageable;
import webmobileshop.dto.ProductDTO;
import webmobileshop.dto.ShoppingCartDTO;

import java.util.Date;
import java.util.List;

public interface ShoppingCartService {

    List<ShoppingCartDTO> getAllShoppingCart(Pageable pageable);
    int totalItem();
    ShoppingCartDTO getByShoppingCartId(Long shoppingCartId);
    List<ShoppingCartDTO>  getByProductId(Long productId);
    List<ShoppingCartDTO>  getByUserId(String userId);
    List<ShoppingCartDTO>  getByExtraDay(Date extraDay);

    void createShoppingCart(ShoppingCartDTO shoppingCartDTO);
    void updateShoppingCart( ShoppingCartDTO shoppingCartDTO);
    void deleteByShoppingCartId(Long shoppingCartId);

}
