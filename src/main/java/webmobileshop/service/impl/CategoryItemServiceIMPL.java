package webmobileshop.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import webmobileshop.Configproject.OpjectMapper.CategoryItemMapper;
import webmobileshop.dto.CategoryDTO;
import webmobileshop.dto.CategotyItemDTO;
import webmobileshop.entity.CategoryItemEntity;
import webmobileshop.entity.CtegoryEntity;
import webmobileshop.repositorty.CategoryItemRepository;
import webmobileshop.service.CategoryItemService;
import webmobileshop.service.CategoryService;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryItemServiceIMPL implements CategoryItemService {
    @Autowired
    private final CategoryItemRepository categoryItemRepository;
    private ModelMapper modelMapper;
    private CategoryItemMapper categoryItemMapper;

    public CategoryItemServiceIMPL(CategoryItemRepository categoryItemRepository, ModelMapper modelMapper, CategoryItemMapper categoryItemMapper) {
        this.categoryItemRepository = categoryItemRepository;
        this.modelMapper = modelMapper;
        this.categoryItemMapper = categoryItemMapper;
    }


    @Override
    public CategotyItemDTO getByCategoryItemId(Long categoryItemId) {
        try {
            CategoryItemEntity categoryItemEntity = categoryItemRepository.findByCategoryItemId(categoryItemId)
                    .orElseThrow(() -> new EntityNotFoundException("Data not found with ID: " + categoryItemId));
            return categoryItemMapper.toDTO(categoryItemEntity);
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public List<CategotyItemDTO> getAllCategioryItem(Pageable pageable) {
        List<CategotyItemDTO> results = new ArrayList<>();
        List<CategoryItemEntity> categoryItemEntities = categoryItemRepository.findAll(pageable).getContent();
        for (CategoryItemEntity item: categoryItemEntities
        ) {
            CategotyItemDTO categotyItemDTO = categoryItemMapper.toDTO(item);
            results.add(categotyItemDTO);
        }
        return results;
    }

    @Override
    public int totalItem() {
        return (int) categoryItemRepository.count();
    }

    @Override
    public List<CategotyItemDTO> getByCategoryItemName(String categoryItemName) {
        List<CategoryItemEntity> categoryItemEntities = categoryItemRepository.findByCategoryItemName(categoryItemName);
        return categoryItemEntities.stream()
                .map(categoryItem -> categoryItemMapper.toDTO(categoryItem))
                .collect(Collectors.toList());
    }

    @Override
    public void createByCategoryItem(CategotyItemDTO categotyItemDTO) {
        if (categotyItemDTO != null) {
            CategoryItemEntity categoryItemEntity = categoryItemMapper.toEntity(categotyItemDTO);
            if (categoryItemEntity != null) {
                categoryItemRepository.save(categoryItemEntity);
            } else {
                throw new RuntimeException("Không lấy được dữ liệu của Entity");
            }
        }
    }

    @Override
    public void updateByCategoryItem(CategotyItemDTO categotyItemDTO) {
        CategoryItemEntity categoryItemEntity = categoryItemRepository.findByCategoryItemId(categotyItemDTO.getCategoryItemId())
                .orElseThrow(() -> new RuntimeException("Khong tim thay du lieu User"));
        modelMapper.map(categotyItemDTO, categoryItemEntity);
        categoryItemRepository.save(categoryItemEntity);
    }

    @Override
    public void deleteByCategoryItemId(Long categoryItemId) {
        categoryItemRepository.deleteByCategoryItemId(categoryItemId);
    }
}
