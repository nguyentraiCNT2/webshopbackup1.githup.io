package webmobileshop.repositorty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webmobileshop.entity.ProductsEntity;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductsRepository  extends JpaRepository<ProductsEntity, Long> {
    Optional<ProductsEntity> findByProductId(Long productId);
    List<ProductsEntity> findByProductcore(String productcore);
    List<ProductsEntity> findByProductName(String productName);
    List<ProductsEntity> findByProductPrice(BigDecimal productPrice);
    List<ProductsEntity> findByProductView(int productView);
    List<ProductsEntity> findByQuantityinstock(int quantityinstock);
    List<ProductsEntity>  findByCategoryItemId(Long categoryItemId);
    List<ProductsEntity>  findByCategoryId(Long categoryId);
    List<ProductsEntity>  findByCorlorId(Long corlorId);
    List<ProductsEntity>  findBySizeId(Long sizeId);
    void deleteByProductId(Long  productId);
    ProductsEntity saveAndFlush(ProductsEntity productsEntity);
}
