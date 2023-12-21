package webmobileshop.service;

import org.springframework.data.domain.Pageable;
import webmobileshop.dto.CategoryDTO;
import webmobileshop.dto.CategotyItemDTO;

import java.util.List;

public interface CategoryItemService {
    CategotyItemDTO getByCategoryItemId(Long categoryItemId);

    List<CategotyItemDTO> getAllCategioryItem(Pageable pageable);
    int totalItem();
    List<CategotyItemDTO> getByCategoryItemName(String categoryItemName);

    void createByCategoryItem(CategotyItemDTO categotyItemDTO);

    void updateByCategoryItem( CategotyItemDTO categotyItemDTO);

    void deleteByCategoryItemId(Long categoryItemId);

}
