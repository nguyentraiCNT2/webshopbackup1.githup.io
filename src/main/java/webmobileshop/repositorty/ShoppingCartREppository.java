package webmobileshop.repositorty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webmobileshop.entity.ProductsEntity;
import webmobileshop.entity.ShoppingCartEntity;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShoppingCartREppository  extends JpaRepository<ShoppingCartEntity, Long> {
    Optional<ShoppingCartEntity> findByShoppingCartId(Long shoppingCartId);
    List<ShoppingCartEntity> findByUserId(String userId);
    List<ShoppingCartEntity>  findByProductId(Long productId);
    List<ShoppingCartEntity>  findByExtraDay(Date extraDay);
    void deleteByShoppingCartId(Long shoppingCartId);
    ShoppingCartEntity saveAndFlush(ShoppingCartEntity shoppingCartEntity);
}
