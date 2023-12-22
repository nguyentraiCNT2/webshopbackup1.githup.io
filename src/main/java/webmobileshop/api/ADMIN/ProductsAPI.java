package webmobileshop.api.ADMIN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import webmobileshop.api.OUTPUT.ProductsOUTPUT;
import webmobileshop.dto.ProductDTO;
import webmobileshop.dto.UserAccountDTO;
import webmobileshop.dto.UserTokenDTO;
import webmobileshop.service.ProductsService;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/san-pham/api")
public class ProductsAPI {
    @Autowired
    private final ProductsService productsService;

    public ProductsAPI(ProductsService productsService) {
        this.productsService = productsService;
    }


    @GetMapping("/product/product-list")
    public ProductsOUTPUT getAllProduct(@RequestParam("page") int page, @RequestParam("limit") int limit, Model model){
        ProductsOUTPUT result = new ProductsOUTPUT();
        result.setPage(page);
        Pageable pageable = new PageRequest(page - 1, limit);
        result.setListResult(productsService.getAllProduct(pageable));
        result.setTotalPage((int) Math.ceil((double) (productsService.totalItem()) / limit));
        model.addAttribute("userTokenOUTPUT", result);

        return result;
    }

    @GetMapping("/product/get-by-productid/{productId}")
    public ResponseEntity<?> getByProductId(@PathVariable Long productId) {
        try {
          ProductDTO productDTOS = productsService.getByProductId(productId);

            return new ResponseEntity<>(productDTOS, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>((List<UserAccountDTO>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/admin/product/get-by-productcore/{productcore}")
    public ResponseEntity<?> getByProductcore(@PathVariable String productcore) {
        try {
            List<ProductDTO> productDTOS = productsService.getByProductcore(productcore);
            return new ResponseEntity<>(productDTOS, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/admin/product/get-by-productname/{productName}")
    public ResponseEntity<?> geByProductName(@PathVariable String productName) {
        try {
            List<ProductDTO> productDTOS = productsService.getByProductName(productName);
            return new ResponseEntity<>(productDTOS, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/admin/product/get-by-productprice/{productPrice}")
    public ResponseEntity<?> getByProductPrice(@PathVariable BigDecimal productPrice) {
        try {
            List<ProductDTO> productDTOS = productsService.getByProductPrice(productPrice);
            return new ResponseEntity<>(productDTOS, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/admin/product/get-by-productview/{productView}")
    public ResponseEntity<?> getByProductView(@PathVariable int productView) {
        try {
            List<ProductDTO> productDTOS = productsService.getByProductView(productView);
            return new ResponseEntity<>(productDTOS, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/admin/product/get-by-quantityinstock/{quantityinstock}")
    public ResponseEntity<?> getByQuantityinstock(@PathVariable int quantityinstock) {
        try {
            List<ProductDTO> productDTOS = productsService.getByQuantityinstock(quantityinstock);
            return new ResponseEntity<>(productDTOS, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/product/get-by-categoryitemid/{categoryItemId}")
    public ResponseEntity<String> findByCategoryItemId(@PathVariable Long categoryItemId) {
        List<ProductDTO>  productDTOS = productsService.getByCategoryItemId(categoryItemId);

        if (productDTOS == null) {
            // Trả về 404 Not Found nếu không tìm thấy kết quả
            return ResponseEntity.notFound().build();

        }

        Map<String, Object> response = new HashMap<>();
        response.put("product",productDTOS);
        // Trả về kết quả nếu tìm thấy
        return new ResponseEntity<>(response+"",HttpStatus.OK);
    }
    @GetMapping("/product/get-by-categoryid/{categoryId}")
    public ResponseEntity<String> getByCategoryId(@PathVariable Long categoryId) {
        List<ProductDTO>  productDTOS = productsService.getByCategoryId(categoryId);

        if (productDTOS == null) {
            // Trả về 404 Not Found nếu không tìm thấy kết quả
            return ResponseEntity.notFound().build();

        }

        Map<String, Object> response = new HashMap<>();
        response.put("product",productDTOS);
        // Trả về kết quả nếu tìm thấy
        return new ResponseEntity<>(response+"",HttpStatus.OK);
    }
    @GetMapping("/product/get-by-corlorid/{corlorId}")
    public ResponseEntity<String> getByCorlorId(@PathVariable Long corlorId) {
        List<ProductDTO>  productDTOS = productsService.getByCorlorId(corlorId);

        if (productDTOS == null) {
            // Trả về 404 Not Found nếu không tìm thấy kết quả
            return ResponseEntity.notFound().build();

        }

        Map<String, Object> response = new HashMap<>();
        response.put("product",productDTOS);
        // Trả về kết quả nếu tìm thấy
        return new ResponseEntity<>(response+"",HttpStatus.OK);
    }
    @GetMapping("/product/get-by-sizeid/{sizeId}")
    public ResponseEntity<String> getBySizeId(@PathVariable Long sizeId) {
        List<ProductDTO>  productDTOS = productsService.getBySizeId(sizeId);

        if (productDTOS == null) {
            // Trả về 404 Not Found nếu không tìm thấy kết quả
            return ResponseEntity.notFound().build();

        }

        Map<String, Object> response = new HashMap<>();
        response.put("product",productDTOS);
        // Trả về kết quả nếu tìm thấy
        return new ResponseEntity<>(response+"",HttpStatus.OK);
    }
    @PostMapping("/product/create-products")
    public ResponseEntity<String> createProducts(@RequestBody ProductDTO productDTO) {
        try {
            productsService.createProduct(productDTO);

            return new ResponseEntity<>(" added successfully " , HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/product/update-products/{productId}")
    public ResponseEntity<String> updateProducts(@PathVariable Long productId, @RequestBody ProductDTO productDTO) {
        try {
            productDTO.setProductId(productId);
            productsService.updateProduct(productDTO);
            return new ResponseEntity<>(productDTO+" Update successfully ", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Transactional
    @DeleteMapping("/product/delete-product-by-productid/{productId}")
    public ResponseEntity<String> deleteUserToken(@PathVariable Long productId) {
        try {
            productsService.deleteProduct(productId);
            return new ResponseEntity<>("delete successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
