package webmobileshop.service;

import org.springframework.data.domain.Pageable;
import webmobileshop.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO getByCategoryId(Long categoryId);

    List<CategoryDTO> getAllCategiory(Pageable pageable);
    int totalItem();
    List<CategoryDTO> getByCategoryName(String categoryName);

    void createByCategory(CategoryDTO categoryDTO);

    void updateByCategory( CategoryDTO categoryDTO);

    void deleteBYCategoryId(Long categoryId);
}
