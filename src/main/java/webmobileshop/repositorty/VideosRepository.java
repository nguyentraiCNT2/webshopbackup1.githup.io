package webmobileshop.repositorty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webmobileshop.entity.CategoryItemEntity;
import webmobileshop.entity.VideoEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface VideosRepository extends JpaRepository<VideoEntity, Long> {
    Optional<VideoEntity> findByVideoId(Long videoId);

    List<VideoEntity> findByVideoName(String videoName);
    void deleteByVideoId(Long  videoId);

    VideoEntity saveAndFlush(VideoEntity videoEntity);
}
