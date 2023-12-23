package webmobileshop.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import webmobileshop.Configproject.OpjectMapper.ShoppingCartMapper;
import webmobileshop.dto.ShoppingCartDTO;
import webmobileshop.entity.*;
import webmobileshop.repositorty.ProductsRepository;
import webmobileshop.repositorty.ShoppingCartREppository;
import webmobileshop.repositorty.UserAccountRepository;
import webmobileshop.service.ShoppingCartService;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceIMPL implements ShoppingCartService {
    @Autowired
    private final ShoppingCartREppository shoppingCartREppository;
    private ModelMapper modelMapper;
    private ShoppingCartMapper shoppingCartMapper;
    private UserAccountRepository userAccountRepository;
    private ProductsRepository productsRepository;

    public ShoppingCartServiceIMPL(ShoppingCartREppository shoppingCartREppository, ModelMapper modelMapper
            , ShoppingCartMapper shoppingCartMapper, UserAccountRepository userAccountRepository
            , ProductsRepository productsRepository) {
        this.shoppingCartREppository = shoppingCartREppository;
        this.modelMapper = modelMapper;
        this.shoppingCartMapper = shoppingCartMapper;
        this.userAccountRepository = userAccountRepository;
        this.productsRepository = productsRepository;
    }

    @Override
    public List<ShoppingCartDTO> getAllShoppingCart(Pageable pageable) {
        List<ShoppingCartDTO> results = new ArrayList<>();
        List<ShoppingCartEntity> shoppingCartEntities = shoppingCartREppository.findAll(pageable).getContent();
        for (ShoppingCartEntity item: shoppingCartEntities
        ) {
            ShoppingCartDTO shoppingCartDTO  = shoppingCartMapper.toDTO(item);
            results.add( shoppingCartDTO );
        }
        return results;
    }

    @Override
    public int totalItem() {
        return (int) shoppingCartREppository.count();
    }

    @Override
    public ShoppingCartDTO getByShoppingCartId(Long shoppingCartId) {
        try {
            ShoppingCartEntity shoppingCartEntity = shoppingCartREppository.findByShoppingCartId(shoppingCartId)
                    .orElseThrow(() -> new EntityNotFoundException("Data not found with ID: " + shoppingCartId));
            return shoppingCartMapper.toDTO(shoppingCartEntity);
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public List<ShoppingCartDTO> getByProductId(Long productId) {
        List<ShoppingCartEntity> shoppingCartEntities = shoppingCartREppository.findByProductId(productId);
        return shoppingCartEntities.stream()
                .map(shoppingCartMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ShoppingCartDTO> getByUserId(String userId) {
        List<ShoppingCartEntity> shoppingCartEntities = shoppingCartREppository.findByUserId(userId);
        return shoppingCartEntities.stream()
                .map(shoppingCartMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ShoppingCartDTO> getByExtraDay(Date extraDay) {
        List<ShoppingCartEntity> shoppingCartEntities = shoppingCartREppository.findByExtraDay(extraDay);
        return shoppingCartEntities.stream()
                .map(shoppingCartMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void createShoppingCart(ShoppingCartDTO shoppingCartDTO) {
        if (shoppingCartDTO != null) {
            ShoppingCartEntity shoppingCartEntity = shoppingCartMapper.toEntity(shoppingCartDTO);
            UserAccountEntity userAccountEntity = userAccountRepository.findByuserId(shoppingCartDTO.getUserId()).orElse(null);
            ProductsEntity productsEntity = productsRepository.findByProductId(shoppingCartDTO.getProductId()).orElse(null);

            if (shoppingCartEntity != null) {
                shoppingCartEntity.setUserId(userAccountEntity);
                shoppingCartEntity.setProductId(productsEntity);
                shoppingCartREppository.save(shoppingCartEntity);
            } else {
                throw new RuntimeException("Không lấy được dữ liệu của Entity");
            }
        }
    }

    @Override
    public void updateShoppingCart(ShoppingCartDTO shoppingCartDTO) {
        ShoppingCartEntity existingShoppingCart = shoppingCartREppository.findByShoppingCartId(shoppingCartDTO.getShoppingCartId())
                .orElseThrow(() -> new RuntimeException("Khong tim thay du lieu User"));
        modelMapper.map(shoppingCartDTO, existingShoppingCart);
        shoppingCartREppository.save(existingShoppingCart);
    }

    @Override
    public void deleteByShoppingCartId(Long shoppingCartId) {
        shoppingCartREppository.deleteByShoppingCartId(shoppingCartId);
    }
}
