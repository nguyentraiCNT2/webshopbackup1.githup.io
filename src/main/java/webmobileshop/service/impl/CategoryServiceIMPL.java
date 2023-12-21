package webmobileshop.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import webmobileshop.Configproject.OpjectMapper.CategoryMapper;
import webmobileshop.dto.CategoryDTO;
import webmobileshop.dto.UserAddressDTO;
import webmobileshop.entity.CtegoryEntity;
import webmobileshop.entity.UserAccountEntity;
import webmobileshop.entity.UserAddressEntity;
import webmobileshop.repositorty.CategoryRepository;
import webmobileshop.service.CategoryService;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceIMPL implements CategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;
    private ModelMapper modelMapper;
    private CategoryMapper categoryMapper;

    public CategoryServiceIMPL(CategoryRepository categoryRepository, ModelMapper modelMapper, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.categoryMapper = categoryMapper;
    }


    @Override
    public CategoryDTO getByCategoryId(Long categoryId) {
        try {
            CtegoryEntity ctegoryEntity = categoryRepository.findByCategoryId(categoryId)
                    .orElseThrow(() -> new EntityNotFoundException("Data not found with ID: " + categoryId));
            return categoryMapper.toDTO(ctegoryEntity);
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public List<CategoryDTO> getAllCategiory(Pageable pageable) {
        List<CategoryDTO> results = new ArrayList<>();
        List<CtegoryEntity> caCtegoryEntities = categoryRepository.findAll(pageable).getContent();
        for (CtegoryEntity item: caCtegoryEntities
        ) {
            CategoryDTO categoryDTO = categoryMapper.toDTO(item);
            results.add(categoryDTO);
        }
        return results;
    }

    @Override
    public int totalItem() {
        return (int) categoryRepository.count();
    }

    @Override
    public List<CategoryDTO> getByCategoryName(String categoryName) {
        List<CtegoryEntity> ctegoryEntities = categoryRepository.findByCategoryName(categoryName);
        return ctegoryEntities.stream()
                .map(useraddress -> categoryMapper.toDTO(useraddress))
                .collect(Collectors.toList());
    }

    @Override
    public void createByCategory(CategoryDTO categoryDTO) {
        if (categoryDTO != null) {
            CtegoryEntity ctegoryEntity = categoryMapper.toEntity(categoryDTO);
            if (ctegoryEntity != null) {
                categoryRepository.save(ctegoryEntity);
            } else {
                throw new RuntimeException("Không lấy được dữ liệu của Entity");
            }
        }
    }

    @Override
    public void updateByCategory(CategoryDTO categoryDTO) {
        CtegoryEntity ctegoryEntity = categoryRepository.findByCategoryId(categoryDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Khong tim thay du lieu User"));
        modelMapper.map(categoryDTO, ctegoryEntity);
        categoryRepository.save(ctegoryEntity);
    }

    @Override
    public void deleteBYCategoryId(Long categoryId) {
        categoryRepository.deleteByCategoryId(categoryId);
    }
}
