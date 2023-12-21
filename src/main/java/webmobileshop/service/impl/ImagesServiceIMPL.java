package webmobileshop.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webmobileshop.Configproject.OpjectMapper.ImagesMapper;
import webmobileshop.dto.ImagesDTO;
import webmobileshop.dto.RoleDTO;
import webmobileshop.entity.ImagesEntity;
import webmobileshop.entity.RoleEntity;
import webmobileshop.repositorty.ImagesRepository;
import webmobileshop.service.ImagesService;

@Service
public class ImagesServiceIMPL implements ImagesService {
	@Autowired
	private ImagesRepository imagesRepository;
	private ImagesMapper imagesMapper;
	private ModelMapper modelMapper;
	@Autowired
	public ImagesServiceIMPL(ImagesRepository imagesRepository, ImagesMapper imagesMapper, ModelMapper modelMapper) {
		super();
		this.imagesRepository = imagesRepository;
		this.imagesMapper = imagesMapper;
		this.modelMapper = modelMapper;
	}

	@Override
	public void createImages(ImagesDTO imagesDTO) {
		if (imagesDTO != null) {
			String name = imagesDTO.getName();
			if (name != null) {
				ImagesEntity imagesEntity = imagesMapper.toEntity(imagesDTO);
				if (imagesEntity != null) {
					
					imagesRepository.save(imagesEntity);
				} else {
					System.err.println("Không có dữ liệu về Ảnh , kết nối thất bại");
				}

			} else {
				System.err.println("Ảnh chua duoc chuyen ve Data: "+imagesDTO.getName());
			}
		} else {
			System.err.println("Không tìm thấy thông tin Ảnh trong dữ liệu");
		}
		
	}
	@Override
	public void updateImages(ImagesDTO imagesDTO) {
		ImagesEntity existingImages = imagesRepository.findByImagesId(imagesDTO.getImagesId())
				.orElseThrow(() -> new RuntimeException("Không tìm thấy Quyền"));
		modelMapper.map(imagesDTO, existingImages);
		imagesRepository.save(existingImages);
	}
	@Override
	public void deleteImages(Long imagesId) {
		imagesRepository.deleteByImagesId(imagesId);
		
	}
	@Override
	public List<ImagesDTO> getAllImages() {
	    List<ImagesEntity> images = imagesRepository.findAll();
	    return images.stream()
	            .map(image -> modelMapper.map(image, ImagesDTO.class))
	            .collect(Collectors.toList());
	}

	@Override
	public List<ImagesDTO> getname(String name) {
		List<ImagesEntity> images = imagesRepository.findByname(name);
		return images.stream().map(image -> modelMapper.map(image, ImagesDTO.class)).collect(Collectors.toList());
	}

	@Override
	public ImagesDTO getByImagesId(Long imagesId) {
		ImagesEntity imagesEntity = imagesRepository.findByImagesId(imagesId)
				.orElseThrow(() -> new RuntimeException("Không tìm thấy ảnh"));
		return modelMapper.map(imagesEntity, ImagesDTO.class);
	}
	

	
}
