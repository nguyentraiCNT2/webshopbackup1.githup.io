package webmobileshop.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import webmobileshop.Configproject.OpjectMapper.SizeMapper;
import webmobileshop.dto.CorlorDTO;
import webmobileshop.dto.SizeDTO;
import webmobileshop.entity.CorlorEntity;
import webmobileshop.entity.SizeEntity;
import webmobileshop.repositorty.SizeRepository;
import webmobileshop.service.SizeService;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SizeServiceIMPL implements SizeService {

    @Autowired
    private final SizeRepository sizeRepository;
    private ModelMapper modelMapper;
    private SizeMapper sizeMapper;

    public SizeServiceIMPL(SizeRepository sizeRepository, ModelMapper modelMapper, SizeMapper sizeMapper) {
        this.sizeRepository = sizeRepository;
        this.modelMapper = modelMapper;
        this.sizeMapper = sizeMapper;
    }

    @Override
    public SizeDTO getBySizeId(Long sizeId) {
        try {
            SizeEntity sizeEntity = sizeRepository.findBySizeId(sizeId)
                    .orElseThrow(() -> new EntityNotFoundException("Data not found with ID: " + sizeId));
            return sizeMapper.toDTO(sizeEntity);
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public List<SizeDTO> getAllSize(Pageable pageable) {
        List<SizeDTO> results = new ArrayList<>();
        List<SizeEntity> sizeEntities = sizeRepository.findAll(pageable).getContent();
        for (SizeEntity item: sizeEntities) {
            SizeDTO sizeDTO = sizeMapper.toDTO(item);
            results.add(sizeDTO);
        }
        return results;
    }

    @Override
    public int totalItem() {
        return (int) sizeRepository.count();
    }

    @Override
    public List<SizeDTO> getBySizeName(String sizeName) {
        List<SizeEntity> sizeEntityList = sizeRepository.findBySizeName(sizeName);
        return sizeEntityList.stream()
                .map(sizeEntity -> sizeMapper.toDTO(sizeEntity))
                .collect(Collectors.toList());
    }

    @Override
    public void createBySize(SizeDTO sizeDTO) {
        if (sizeDTO != null) {
            SizeEntity sizeEntity = sizeMapper.toEntity(sizeDTO);
            if (sizeEntity != null) {
                sizeRepository.save(sizeEntity);
            } else {
                throw new RuntimeException("Không lấy được dữ liệu của Entity");
            }
        }
    }

    @Override
    public void updateBySize(SizeDTO sizeDTO) {
        SizeEntity sizeEntity = sizeRepository.findBySizeId(sizeDTO.getSizeId())
                .orElseThrow(() -> new RuntimeException("Khong tim thay du lieu User"));
        modelMapper.map(sizeDTO, sizeEntity);
        sizeRepository.save(sizeEntity);
    }

    @Override
    public void deleteBySizeId(Long sizeId) {
        sizeRepository.deleteBySizeId(sizeId);
    }
}
