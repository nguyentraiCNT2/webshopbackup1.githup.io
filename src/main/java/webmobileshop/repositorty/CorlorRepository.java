package webmobileshop.repositorty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webmobileshop.entity.CorlorEntity;
import webmobileshop.entity.VideoEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface CorlorRepository extends JpaRepository<CorlorEntity, Long> {
    Optional<CorlorEntity> findByCorlorId(Long corlorId);
    List<CorlorEntity> findByCorlorName(String corlorName);
    List<CorlorEntity> findByCorlorCore(String corlorCore);
    void deleteByCorlorId(Long corlorId);
    CorlorEntity saveAndFlush(CorlorEntity corlorEntity);
}
