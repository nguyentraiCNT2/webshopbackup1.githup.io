package webmobileshop.service;

import org.springframework.data.domain.Pageable;
import webmobileshop.dto.CorlorDTO;
import webmobileshop.dto.VideoDTO;

import java.util.List;

public interface CorlorService {
    CorlorDTO getByCorlorId(Long corlorId);

    List<CorlorDTO> getAllCorlor(Pageable pageable);
    int totalItem();
    List<CorlorDTO> getByCorlorName(String corlorName);

    List<CorlorDTO> getByCorlorCore(String corlorCore);
    void createByCorlor(CorlorDTO corlorDTO);

    void updateByCorlor( CorlorDTO corlorDTO);

    void deleteByCorlorId(Long corlorId);
}
