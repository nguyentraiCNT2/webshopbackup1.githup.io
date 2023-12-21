package webmobileshop.api.ADMIN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import webmobileshop.api.OUTPUT.CategoryItemOUTPUT;
import webmobileshop.api.OUTPUT.CategoryOUTPUT;
import webmobileshop.dto.CategoryDTO;
import webmobileshop.dto.CategotyItemDTO;
import webmobileshop.dto.UserAddressDTO;
import webmobileshop.service.CategoryItemService;

import java.util.List;

@RestController
@RequestMapping("/admin/hang-san-pham/api")
public class CategoryItemAPI {
    @Autowired
    private final CategoryItemService categoryItemService;


    public CategoryItemAPI(CategoryItemService categoryItemService) {
        this.categoryItemService = categoryItemService;
    }

    @GetMapping("/admin/category-item-list")
    public CategoryItemOUTPUT getAllCategoryItem(@RequestParam("page") int page, @RequestParam("limit") int limit, Model model){
        CategoryItemOUTPUT result = new CategoryItemOUTPUT();
        result.setPage(page);
        Pageable pageable = new PageRequest(page - 1, limit);
        result.setListResult(categoryItemService.getAllCategioryItem(pageable));
        result.setTotalPage((int) Math.ceil((double) (categoryItemService.totalItem()) / limit));
        model.addAttribute("CategoryItemOutput", result);
        return result;

    }

    @GetMapping("/admin/category-Item-products/category-by-id/{categoryItemId}")
    public ResponseEntity<?> getByCategoryItemId(@PathVariable Long categoryItemId) {
        try {
            CategotyItemDTO categotyItemDTO = categoryItemService.getByCategoryItemId(categoryItemId);

            return new ResponseEntity<>(categotyItemDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>((List<UserAddressDTO>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/admin/category-item-products/create-category-item-products")
    public ResponseEntity<String> createCategoryItem(@RequestBody CategotyItemDTO categotyItemDTO) {
        try {
            categoryItemService.createByCategoryItem(categotyItemDTO);

            return new ResponseEntity<>(" added successfully " , HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/admin/update-category-item/{categoryItemId}")
    public ResponseEntity<String> updateCategoryItem(@PathVariable Long categoryItemId, @RequestBody CategotyItemDTO categotyItemDTO) {
        try {
            categotyItemDTO.setCategoryItemId(categoryItemId);
            categoryItemService.updateByCategoryItem(categotyItemDTO);
            return new ResponseEntity<>(categotyItemDTO+" Update successfully ", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/admin/delete-category-item/{categoryItemId}")
    public ResponseEntity<String> deleteCategoryItem(@PathVariable Long categoryItemId) {
        try {
            categoryItemService.deleteByCategoryItemId(categoryItemId);
            return new ResponseEntity<>("delete successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
