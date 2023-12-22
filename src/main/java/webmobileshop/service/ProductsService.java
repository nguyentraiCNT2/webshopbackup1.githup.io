package webmobileshop.service;

import org.springframework.data.domain.Pageable;
import webmobileshop.dto.ProductDTO;
import webmobileshop.dto.UserAccountDTO;
import webmobileshop.entity.ProductsEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductsService {
    List<ProductDTO> getAllProduct(Pageable pageable);
    int totalItem();
    ProductDTO getByProductId(Long productId);
    List<ProductDTO> getByProductcore(String productcore);
    List<ProductDTO> getByProductName(String productName);
    List<ProductDTO> getByProductPrice(BigDecimal productPrice);
    List<ProductDTO> getByProductView(int productView);
    List<ProductDTO> getByQuantityinstock(int quantityinstock);
    List<ProductDTO>  getByCategoryItemId(Long categoryItemId);
    List<ProductDTO>  getByCategoryId(Long categoryId);
    List<ProductDTO>  getByCorlorId(Long corlorId);
    List<ProductDTO>  getBySizeId(Long sizeId);
    void createProduct(ProductDTO productDTO);
    void updateProduct( ProductDTO productDTO);
    void deleteProduct(Long productId);
}
