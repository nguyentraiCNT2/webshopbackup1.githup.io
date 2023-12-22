package webmobileshop.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import webmobileshop.Configproject.OpjectMapper.ProductsMapper;
import webmobileshop.dto.ProductDTO;
import webmobileshop.entity.*;
import webmobileshop.repositorty.*;
import webmobileshop.service.ProductsService;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductsServiceIMPL implements ProductsService {
    @Autowired
    private final ProductsRepository productsRepository;
    private ProductsMapper productsMapper;
    private ModelMapper modelMapper;
    private ImagesRepository imagesRepository;
    private VideosRepository videosRepository;
    private CategoryItemRepository categoryItemRepository;
    private CategoryRepository categoryRepository;
    private SizeRepository sizeRepository;
    private CorlorRepository corlorRepository;

    public ProductsServiceIMPL(ProductsRepository productsRepository, ProductsMapper productsMapper, ModelMapper modelMapper, ImagesRepository imagesRepository, VideosRepository videosRepository, CategoryItemRepository categoryItemRepository, CategoryRepository categoryRepository, SizeRepository sizeRepository, CorlorRepository corlorRepository) {
        this.productsRepository = productsRepository;
        this.productsMapper = productsMapper;
        this.modelMapper = modelMapper;
        this.imagesRepository = imagesRepository;
        this.videosRepository = videosRepository;
        this.categoryItemRepository = categoryItemRepository;
        this.categoryRepository = categoryRepository;
        this.sizeRepository = sizeRepository;
        this.corlorRepository = corlorRepository;
    }


    @Override
    public List<ProductDTO> getAllProduct(Pageable pageable) {
        List<ProductDTO> results = new ArrayList<>();
        List<ProductsEntity> productsEntityList = productsRepository.findAll(pageable).getContent();
        for (ProductsEntity item: productsEntityList
        ) {
            ProductDTO productDTO = productsMapper.toDTO(item);
            results.add(productDTO);
        }
        return results;
    }

    @Override
    public int totalItem() {
            return (int) productsRepository.count();
    }

    @Override
    public ProductDTO getByProductId(Long productId) {
        try {
            ProductsEntity productsEntity = productsRepository.findByProductId(productId)
                    .orElseThrow(() -> new EntityNotFoundException("Data not found with ID: " + productId));
            return productsMapper.toDTO(productsEntity);
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public List<ProductDTO> getByProductcore(String productcore) {
        List<ProductsEntity> productsEntityList = productsRepository.findByProductcore(productcore);
        return productsEntityList.stream()
                .map(productsEntity -> productsMapper.toDTO(productsEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getByProductName(String productName) {
        List<ProductsEntity> productsEntityList = productsRepository.findByProductName(productName);
        return productsEntityList.stream()
                .map(productsEntity -> productsMapper.toDTO(productsEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getByProductPrice(BigDecimal productPrice) {
        List<ProductsEntity> productsEntityList = productsRepository.findByProductPrice(productPrice);
        return productsEntityList.stream()
                .map(productsEntity -> productsMapper.toDTO(productsEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getByProductView(int productView) {
        List<ProductsEntity> productsEntityList = productsRepository.findByProductView(productView);
        return productsEntityList.stream()
                .map(productsEntity -> productsMapper.toDTO(productsEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getByQuantityinstock(int quantityinstock) {
        List<ProductsEntity> productsEntityList = productsRepository.findByQuantityinstock(quantityinstock);
        return productsEntityList.stream()
                .map(productsEntity -> productsMapper.toDTO(productsEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getByCategoryItemId(Long categoryItemId) {
        List<ProductsEntity> productsEntityList = productsRepository.findByCategoryItemId(categoryItemId);
        return productsEntityList.stream()
                .map(productsEntity -> productsMapper.toDTO(productsEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getByCategoryId(Long categoryId) {
        List<ProductsEntity> productsEntityList = productsRepository.findByCategoryId(categoryId);
        return productsEntityList.stream()
                .map(productsEntity -> productsMapper.toDTO(productsEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getByCorlorId(Long corlorId) {
        List<ProductsEntity> productsEntityList = productsRepository.findByCorlorId(corlorId);
        return productsEntityList.stream()
                .map(productsEntity -> productsMapper.toDTO(productsEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getBySizeId(Long sizeId) {
        List<ProductsEntity> productsEntityList = productsRepository.findBySizeId(sizeId);
        return productsEntityList.stream()
                .map(productsEntity -> productsMapper.toDTO(productsEntity))
                .collect(Collectors.toList());
    }

    @Override
    public void createProduct(ProductDTO productDTO) {
        if (productDTO != null) {
            ProductsEntity productsEntity = productsMapper.toEntity(productDTO);
            ImagesEntity imagesEntity = imagesRepository.findByImagesId(productDTO.getImagesId()).orElse(null);
            VideoEntity videoEntity = videosRepository.findByVideoId(productDTO.getVideoId()).orElse(null);
            CategoryItemEntity categoryItemEntity = categoryItemRepository.findByCategoryItemId(productDTO.getCategoryItemId()).orElse(null);
            CtegoryEntity ctegoryEntity = categoryRepository.findByCategoryId(productDTO.getCategoryId()).orElse(null);
            CorlorEntity corlorEntity = corlorRepository.findByCorlorId(productDTO.getCorlorId()).orElse(null);
            SizeEntity sizeEntity = sizeRepository.findBySizeId(productDTO.getSizeId()).orElse(null);
            if (productsEntity != null) {
                productsEntity.setImagesId(imagesEntity);
                productsEntity.setVideoId(videoEntity);
                productsEntity.setCategoryItemId(categoryItemEntity);
                productsEntity.setCategoryId(ctegoryEntity);
                productsEntity.setCorlorId(corlorEntity);
                productsEntity.setSizeId(sizeEntity);
                productsRepository.save(productsEntity);
            } else {
                throw new RuntimeException("Không lấy được dữ liệu của Entity");
            }
        }
    }

    @Override
    public void updateProduct(ProductDTO productDTO) {
        ProductsEntity existingProducts  = productsRepository.findByProductId(productDTO.getProductId())
                .orElseThrow(() -> new RuntimeException("Khong tim thay du lieu User"));
        modelMapper.map(productDTO, existingProducts);
        productsRepository.save(existingProducts);
    }

    @Override
    public void deleteByProductId(Long productId) {
        productsRepository.deleteByProductId(productId);
    }
}
