package webmobileshop.service;

import java.util.List;

import webmobileshop.dto.ImagesDTO;
import webmobileshop.dto.RoleDTO;

public interface ImagesService {
	ImagesDTO getByImagesId(Long imagesId);
	
	void createImages(ImagesDTO imagesDTO);

    void updateImages( ImagesDTO imagesDTO);

    void deleteImages(Long imagesId);
    
    List<ImagesDTO> getAllImages();
    
    List<ImagesDTO> getname(String name);
}
