package webmobileshop.Configproject.OpjectMapper;


import org.springframework.stereotype.Component;

import org.modelmapper.ModelMapper;
import webmobileshop.dto.ImportDetailDTO;
import webmobileshop.entity.ImportDetailEntity;

@Component
public class ImportDetailMapper {
    private final ImportMapper importMapper;
    private final ProductsMapper productsMapper;
    private final UserAccountMapper userAccountMapper;
    private final ModelMapper modelMapper;
	
    public ImportDetailMapper(ImportMapper importMapper, ProductsMapper productsMapper, UserAccountMapper userAccountMapper,ModelMapper modelMapper) {
        this.importMapper = importMapper;
        this.productsMapper = productsMapper;
        this.userAccountMapper = userAccountMapper;
		this.modelMapper = modelMapper;
    }

    public ImportDetailDTO toDTO(ImportDetailEntity entity) {
        ImportDetailDTO dto = new ImportDetailDTO();
        dto.setImportDetailId(entity.getImportDetailId());
        dto.setImportId(entity.getImportId().getImportId());
        dto.setProductId(entity.getProductId().getProductId());
        dto.setUserId(entity.getUserId().getUserId());
        dto.setPriceAdded(entity.getPriceAdded());
        dto.setQuantityAdded(entity.getQuantityAdded());
        return dto;
    }

    public ImportDetailEntity toEntity(ImportDetailDTO dto) {
        ImportDetailEntity entity = new ImportDetailEntity();
        entity.setImportDetail(dto.getImportDetailId());
        // Assuming you have a method in your service to find ImportEntity by importId
        // and set it to ImportDetailEntity using setImportId() method.
        // entity.setImportId(importService.findImportById(dto.getImportId()));
        // Assuming you have a method in your service to find ProductsEntity by productId
        // and set it to ImportDetailEntity using setProductId() method.
        // entity.setProductId(productsService.findProductById(dto.getProductId()));
        // Assuming you have a method in your service to find UserAccountEntity by userId
        // and set it to ImportDetailEntity using setUserId() method.
        // entity.setUserId(userAccountService.findUserById(dto.getUserId()));
        entity.setPriceAdded(dto.getPriceAdded());
        entity.setQuantityAdded(dto.getQuantityAdded());
        return entity;
    }
}
