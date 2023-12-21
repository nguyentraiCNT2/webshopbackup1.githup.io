package webmobileshop.api.ADMIN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import webmobileshop.api.OUTPUT.CategoryOUTPUT;
import webmobileshop.api.OUTPUT.VideosOUTPUT;
import webmobileshop.dto.CategoryDTO;
import webmobileshop.dto.UserAddressDTO;
import webmobileshop.dto.VideoDTO;
import webmobileshop.service.VideosService;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/admin/video/api")
public class VideosAPI {
    @Autowired
    private final VideosService videosService;

    public VideosAPI(VideosService videosService) {
        this.videosService = videosService;
    }
    @GetMapping("/admin/videos-list")
    public VideosOUTPUT getAllVideos(@RequestParam("page") int page, @RequestParam("limit") int limit, Model model){
        VideosOUTPUT result = new VideosOUTPUT();
        result.setPage(page);
        Pageable pageable = new PageRequest(page - 1, limit);
        result.setListResult(videosService.getAllVideo(pageable));
        result.setTotalPage((int) Math.ceil((double) (videosService.totalItem()) / limit));
        model.addAttribute("VideosOUTPUT", result);
        return result;

    }

    @GetMapping("/admin/videos/videos-by-id/{videoId}")
    public ResponseEntity<?> getByVideoId(@PathVariable Long videoId) {
        try {
            VideoDTO videoDTO = videosService.getByVideoId(videoId);

            return new ResponseEntity<>(videoDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>((List<UserAddressDTO>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/admin/videos/videos-by-videoName/{videoId}")
    public ResponseEntity<?> getByVideoName(@PathVariable String videoName) {
        try {
           List<VideoDTO>  videoDTO = videosService.getByVideoName(videoName);

            return new ResponseEntity<>(videoDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>((List<UserAddressDTO>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/admin/video/create-videos")
    public ResponseEntity<String> createVideo(@RequestBody VideoDTO videoDTO) {
        try {
            videosService.createByVideo(videoDTO);
            return new ResponseEntity<>(" added successfully " , HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/admin/update-video/{videoId}")
    public ResponseEntity<String> updateVideo(@PathVariable Long videoId, @RequestBody VideoDTO videoDTO) {
        try {
            videoDTO.setVideoId(videoId);
            videosService.updateByVideo(videoDTO);
            return new ResponseEntity<>(videoDTO+" Update successfully ", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Transactional
    @DeleteMapping("/admin/delete-videos/{videoId}")
    public ResponseEntity<String> deleteVideo(@PathVariable Long videoId) {
        try {
            videosService.deleteByVideoId(videoId);
            return new ResponseEntity<>("delete successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
