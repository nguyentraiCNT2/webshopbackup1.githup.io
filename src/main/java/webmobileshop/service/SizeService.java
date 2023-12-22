package webmobileshop.service;

import org.springframework.data.domain.Pageable;
import webmobileshop.dto.SizeDTO;

import java.util.List;

public interface SizeService {

    SizeDTO getBySizeId(Long sizeId);

    List<SizeDTO> getAllSize(Pageable pageable);
    int totalItem();
    List<SizeDTO> getBySizeName(String sizeName);

    void createBySize(SizeDTO sizeDTO);

    void updateBySize( SizeDTO sizeDTO);

    void deleteBySizeId(Long sizeId);
}
