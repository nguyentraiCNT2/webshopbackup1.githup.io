package webmobileshop.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import webmobileshop.Configproject.OpjectMapper.VideoMaper;
import webmobileshop.dto.CategotyItemDTO;
import webmobileshop.dto.VideoDTO;
import webmobileshop.entity.CategoryItemEntity;
import webmobileshop.entity.VideoEntity;
import webmobileshop.repositorty.VideosRepository;
import webmobileshop.service.VideosService;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideosServiceIMPL implements VideosService {

    @Autowired
    private final VideosRepository videosRepository;
    private VideoMaper videoMaper;
    private ModelMapper modelMapper;

    public VideosServiceIMPL(VideosRepository videosRepository, VideoMaper videoMaper, ModelMapper modelMapper) {
        this.videosRepository = videosRepository;
        this.videoMaper = videoMaper;
        this.modelMapper = modelMapper;
    }


    @Override
    public VideoDTO getByVideoId(Long videoId) {
        try {
            VideoEntity videoEntity = videosRepository.findByVideoId(videoId)
                    .orElseThrow(() -> new EntityNotFoundException("Data not found with ID: " + videoId));
            return videoMaper.toDTO(videoEntity);
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public List<VideoDTO> getAllVideo(Pageable pageable) {
        List<VideoDTO> results = new ArrayList<>();
        List<VideoEntity> videoEntities = videosRepository.findAll(pageable).getContent();
        for (VideoEntity item: videoEntities) {
            VideoDTO videoDTO = videoMaper.toDTO(item);
            results.add(videoDTO);
        }
        return results;
    }

    @Override
    public int totalItem() {
        return (int) videosRepository.count();
    }

    @Override
    public List<VideoDTO> getByVideoName(String videoName) {
        List<VideoEntity> videoEntities = videosRepository.findByVideoName(videoName);
        return videoEntities.stream()
                .map(videoEntity -> videoMaper.toDTO(videoEntity))
                .collect(Collectors.toList());
    }

    @Override
    public void createByVideo(VideoDTO videoDTO) {
        if (videoDTO != null) {
            VideoEntity videoEntity = videoMaper.toEntity(videoDTO);
            if (videoEntity != null) {
                videosRepository.save(videoEntity);
            } else {
                throw new RuntimeException("Không lấy được dữ liệu của Entity");
            }
        }
    }

    @Override
    public void updateByVideo(VideoDTO videoDTO) {
        VideoEntity videoEntity = videosRepository.findByVideoId(videoDTO.getVideoId())
                .orElseThrow(() -> new RuntimeException("Khong tim thay du lieu User"));
        modelMapper.map(videoDTO, videoEntity);
        videosRepository.save(videoEntity);
    }

    @Override
    public void deleteByVideoId(Long videoId) {
        videosRepository.deleteByVideoId(videoId);
    }
}
