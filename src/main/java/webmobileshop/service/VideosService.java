package webmobileshop.service;

import org.springframework.data.domain.Pageable;
import webmobileshop.dto.VideoDTO;

import java.util.List;

public interface VideosService {
    VideoDTO getByVideoId(Long videoId);

    List<VideoDTO> getAllVideo(Pageable pageable);
    int totalItem();
    List<VideoDTO> getByVideoName(String videoName);

    void createByVideo(VideoDTO videoDTO);

    void updateByVideo( VideoDTO videoDTO);

    void deleteByVideoId(Long videoId);
}
