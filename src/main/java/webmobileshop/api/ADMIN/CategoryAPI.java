package webmobileshop.api.ADMIN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import webmobileshop.api.OUTPUT.CategoryOUTPUT;
import webmobileshop.api.OUTPUT.UserAddressOUTPUT;
import webmobileshop.dto.CategoryDTO;
import webmobileshop.dto.UserAddressDTO;
import webmobileshop.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/admin/loai-san-pham/api")
public class CategoryAPI {
    @Autowired
    private final CategoryService categoryService;

    public CategoryAPI(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/admin/category-list")
    public CategoryOUTPUT getAllCategory(@RequestParam("page") int page, @RequestParam("limit") int limit, Model model){
        CategoryOUTPUT result = new CategoryOUTPUT();
        result.setPage(page);
        Pageable pageable = new PageRequest(page - 1, limit);
        result.setListResult(categoryService.getAllCategiory(pageable));
        result.setTotalPage((int) Math.ceil((double) (categoryService.totalItem()) / limit));
        model.addAttribute("Categoryoutput", result);
        return result;

    }

    @GetMapping("/admin/category-products/category-by-id/{categoryId}")
    public ResponseEntity<?> getByCategoryId(@PathVariable Long categoryId) {
        try {
            CategoryDTO categoryDTO = categoryService.getByCategoryId(categoryId);

            return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>((List<UserAddressDTO>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/admin/category-products/create-category-products")
    public ResponseEntity<String> createCategory(@RequestBody CategoryDTO categoryDTO) {
        try {
            categoryService.createByCategory(categoryDTO);

            return new ResponseEntity<>(" added successfully " , HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/admin/update-category/{categoryId}")
    public ResponseEntity<String> updateCategory(@PathVariable Long categoryId, @RequestBody CategoryDTO categoryDTO) {
        try {
            categoryDTO.setCategoryId(categoryId);
            categoryService.updateByCategory(categoryDTO);
            return new ResponseEntity<>(categoryDTO+" Update successfully ", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/admin/delete-category/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId) {
        try {
            categoryService.deleteBYCategoryId(categoryId);
            return new ResponseEntity<>("delete successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
