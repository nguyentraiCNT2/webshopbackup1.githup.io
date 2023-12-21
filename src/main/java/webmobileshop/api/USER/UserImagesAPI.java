package webmobileshop.api.USER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webmobileshop.dto.ImagesDTO;
import webmobileshop.service.ImagesService;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/user/data-luu-chu-anh/api")
public class UserImagesAPI {
    @Autowired
    private ImagesService imagesService;
    @Autowired
    public UserImagesAPI(ImagesService imagesService) {
        super();
        this.imagesService = imagesService;
    }
    @GetMapping("/{ImagesId}")
    public ResponseEntity<?> getImagesById(@PathVariable Long ImagesId) {
        try {
            ImagesDTO imagesDTO = imagesService.getByImagesId(ImagesId);
            return new ResponseEntity<>(imagesDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<ImagesDTO>> getAllImages() {
        try {
            List<ImagesDTO> imagesDTO = imagesService.getAllImages();
            return new ResponseEntity<>(imagesDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>((List<ImagesDTO>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search/ten-anh/{name}")
    public ResponseEntity<?> getImagesByName(@PathVariable String name) {
        try {
            List<ImagesDTO> imagesDTO = imagesService.getname(name);
            return new ResponseEntity<>(imagesDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<String> createImages(@RequestBody ImagesDTO imagesDTO) {
        try {

            imagesService.createImages(imagesDTO);
            return new ResponseEntity<>(imagesDTO+"Thêm mới Ảnh thành công" , HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{ImagesId}")
    public ResponseEntity<String> updateProduct(@PathVariable Long ImagesId, @RequestBody ImagesDTO imagesDTO) {
        try {
            imagesDTO.setImagesId(ImagesId);
            imagesService.updateImages(imagesDTO);
            return new ResponseEntity<>(imagesDTO+"Cập nhật quyền người dùng thành công", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    @DeleteMapping("/{ImagesId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long ImagesId) {
        try {
            imagesService.deleteImages(ImagesId);
            ;
            return new ResponseEntity<>("Xóa Ảnh thành công", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
