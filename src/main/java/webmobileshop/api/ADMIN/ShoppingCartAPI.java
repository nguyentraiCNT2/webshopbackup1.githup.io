package webmobileshop.api.ADMIN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import webmobileshop.api.OUTPUT.ProductsOUTPUT;
import webmobileshop.api.OUTPUT.ShoppingCartOUTPUT;
import webmobileshop.dto.ProductDTO;
import webmobileshop.dto.ShoppingCartDTO;
import webmobileshop.dto.UserAccountDTO;
import webmobileshop.service.ShoppingCartService;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/shopping-cart/api")
public class ShoppingCartAPI {
    @Autowired
    private final ShoppingCartService shoppingCartService;

    public ShoppingCartAPI(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/shopping-cart/shopping-cart-list")
    public ShoppingCartOUTPUT getAllShoppingCart(@RequestParam("page") int page, @RequestParam("limit") int limit, Model model){
        ShoppingCartOUTPUT result = new ShoppingCartOUTPUT();
        result.setPage(page);
        Pageable pageable = new PageRequest(page - 1, limit);
        System.out.println("productsService: " + shoppingCartService);
        System.out.println("pageable: " + pageable);
        result.setListResult(shoppingCartService.getAllShoppingCart(pageable));
        result.setTotalPage((int) Math.ceil((double) (shoppingCartService.totalItem()) / limit));

        model.addAttribute("ShoppingCartOUTPUT", result);
        return result;
    }
    @GetMapping("/shopping-cart/get-by-shoppingcartid/{shoppingCartId}")
    public ResponseEntity<?> getByShoppingCartId(@PathVariable Long shoppingCartId) {
        try {
            ShoppingCartDTO shoppingCartDTO = shoppingCartService.getByShoppingCartId(shoppingCartId);

            return new ResponseEntity<>(shoppingCartDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>((List<UserAccountDTO>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/shopping-cart/get-by-productid/{productId}")
    public ResponseEntity<String> getByProductId(@PathVariable Long productId) {
        List<ShoppingCartDTO>  shoppingCartDTOS = shoppingCartService.getByProductId(productId);

        if (shoppingCartDTOS == null) {
            // Trả về 404 Not Found nếu không tìm thấy kết quả
            return ResponseEntity.notFound().build();

        }

        Map<String, Object> response = new HashMap<>();
        response.put("product",shoppingCartDTOS);
        // Trả về kết quả nếu tìm thấy
        return new ResponseEntity<>(response+"",HttpStatus.OK);
    }
    @GetMapping("/shopping-cart/get-by-userid/{userId}")
    public ResponseEntity<String> getByUserId(@PathVariable String userId) {
        List<ShoppingCartDTO>  shoppingCartDTOS = shoppingCartService.getByUserId(userId);

        if (shoppingCartDTOS == null) {
            // Trả về 404 Not Found nếu không tìm thấy kết quả
            return ResponseEntity.notFound().build();

        }

        Map<String, Object> response = new HashMap<>();
        response.put("product",shoppingCartDTOS);
        // Trả về kết quả nếu tìm thấy
        return new ResponseEntity<>(response+"",HttpStatus.OK);
    }
    @GetMapping("/shopping-cart/get-by-extraday/{extraDay}")
    public ResponseEntity<String> getByExtraDay(@PathVariable Date extraDay) {
        List<ShoppingCartDTO>  shoppingCartDTOS = shoppingCartService.getByExtraDay(extraDay);

        if (shoppingCartDTOS == null) {
            // Trả về 404 Not Found nếu không tìm thấy kết quả
            return ResponseEntity.notFound().build();

        }

        Map<String, Object> response = new HashMap<>();
        response.put("product",shoppingCartDTOS);
        // Trả về kết quả nếu tìm thấy
        return new ResponseEntity<>(response+"",HttpStatus.OK);
    }

    @PostMapping("/shopping-cart/create-shopping-cart")
    public ResponseEntity<String> createProducts(@RequestBody ShoppingCartDTO shoppingCartDTO) {
        try {
            shoppingCartService.createShoppingCart(shoppingCartDTO);

            return new ResponseEntity<>(" added successfully " , HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/shopping-cart/update-shopping-cart/{shoppingCartId}")
    public ResponseEntity<String> updateProducts(@PathVariable Long shoppingCartId, @RequestBody ShoppingCartDTO shoppingCartDTO) {
        try {
            shoppingCartDTO.setProductId(shoppingCartId);
            shoppingCartService.updateShoppingCart(shoppingCartDTO);
            return new ResponseEntity<>(shoppingCartDTO+" Update successfully ", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    @DeleteMapping("/shopping-cart/delete-shopping-cart-by-shoppingcartid/{shoppingCartId}")
    public ResponseEntity<String> deleteUserToken(@PathVariable Long shoppingCartId) {
        try {
            shoppingCartService.deleteByShoppingCartId(shoppingCartId);
            return new ResponseEntity<>("delete successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
