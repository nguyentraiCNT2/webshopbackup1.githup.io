package webmobileshop.repositorty;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import webmobileshop.entity.ImagesEntity;

@Repository
public interface ImagesRepository extends JpaRepository<ImagesEntity, Long> {
	
Optional<ImagesEntity> findByImagesId(Long imagesId);
    
    List<ImagesEntity> findByname(String name);
    
    void deleteByImagesId(Long imagesId);
    
    ImagesEntity saveAndFlush(ImagesEntity imagesEntity);

}
