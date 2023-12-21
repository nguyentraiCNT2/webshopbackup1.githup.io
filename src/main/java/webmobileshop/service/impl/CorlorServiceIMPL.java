package webmobileshop.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import webmobileshop.Configproject.OpjectMapper.CorlorMapper;
import webmobileshop.dto.CorlorDTO;
import webmobileshop.dto.VideoDTO;
import webmobileshop.entity.CorlorEntity;
import webmobileshop.entity.VideoEntity;
import webmobileshop.repositorty.CorlorRepository;
import webmobileshop.service.CorlorService;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CorlorServiceIMPL implements CorlorService {
    @Autowired
    private final CorlorRepository corlorRepository;
    private ModelMapper modelMapper;
    private CorlorMapper corlorMapper;

    public CorlorServiceIMPL(CorlorRepository corlorRepository, ModelMapper modelMapper, CorlorMapper corlorMapper) {
        this.corlorRepository = corlorRepository;
        this.modelMapper = modelMapper;
        this.corlorMapper = corlorMapper;
    }

    @Override
    public CorlorDTO getByCorlorId(Long corlorId) {
        try {
            CorlorEntity corlorEntity = corlorRepository.findByCorlorId(corlorId)
                    .orElseThrow(() -> new EntityNotFoundException("Data not found with ID: " + corlorId));
            return corlorMapper.toDTO(corlorEntity);
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public List<CorlorDTO> getAllCorlor(Pageable pageable) {
        List<CorlorDTO> results = new ArrayList<>();
        List<CorlorEntity> videoEntities = corlorRepository.findAll(pageable).getContent();
        for (CorlorEntity item: videoEntities) {
            CorlorDTO corlorDTO = corlorMapper.toDTO(item);
            results.add(corlorDTO);
        }
        return results;
    }

    @Override
    public int totalItem() {
        return (int) corlorRepository.count();
    }

    @Override
    public List<CorlorDTO> getByCorlorName(String corlorName) {
        List<CorlorEntity> corlorEntities = corlorRepository.findByCorlorName(corlorName);
        return corlorEntities.stream()
                .map(corlorEntity -> corlorMapper.toDTO(corlorEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<CorlorDTO> getByCorlorCore(String corlorCore) {
        List<CorlorEntity> corlorEntities = corlorRepository.findByCorlorCore(corlorCore);
        return corlorEntities.stream()
                .map(corlorEntity -> corlorMapper.toDTO(corlorEntity))
                .collect(Collectors.toList());
    }

    @Override
    public void createByCorlor(CorlorDTO corlorDTO) {
        if (corlorDTO != null) {
            CorlorEntity corlorEntity = corlorMapper.toEntity(corlorDTO);
            if (corlorEntity != null) {
                corlorRepository.save(corlorEntity);
            } else {
                throw new RuntimeException("Không lấy được dữ liệu của Entity");
            }
        }
    }

    @Override
    public void updateByCorlor(CorlorDTO corlorDTO) {
        CorlorEntity corlorEntity = corlorRepository.findByCorlorId(corlorDTO.getCorlorId())
                .orElseThrow(() -> new RuntimeException("Khong tim thay du lieu User"));
        modelMapper.map(corlorDTO, corlorEntity);
        corlorRepository.save(corlorEntity);
    }

    @Override
    public void deleteByCorlorId(Long corlorId) {
        corlorRepository.deleteByCorlorId(corlorId);
    }
}
