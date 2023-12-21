package webmobileshop.Configproject.OpjectMapper;


import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;
import webmobileshop.dto.VideoDTO;
import webmobileshop.entity.VideoEntity;

@Component
public class VideoMaper {

	  private final ModelMapper modelMapper;
		
	    public VideoMaper(ModelMapper modelMapper) {
			this.modelMapper = modelMapper;
		}
    public VideoDTO toDTO(VideoEntity entity) {
        VideoDTO dto = new VideoDTO();
        dto.setVideoId(entity.getVideoId());
        dto.setVideoName(entity.getVideoName());
        dto.setShowOrHidden(entity.isShowOrHidden());
        return dto;
    }

    public VideoEntity toEntity(VideoDTO dto) {
        VideoEntity entity = new VideoEntity();
        entity.setVideoId(dto.getVideoId());
        entity.setVideoName(dto.getVideoName());
        entity.setShowOrHidden(dto.isShowOrHidden());
        return entity;
    }
}
