package webmobileshop.repositorty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webmobileshop.entity.CorlorEntity;
import webmobileshop.entity.SizeEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface SizeRepository extends JpaRepository<SizeEntity, Long> {
    Optional<SizeEntity> findBySizeId(Long sizeId);
    List<SizeEntity> findBySizeName(String sizeName);
    void deleteBySizeId(Long sizeId);
    SizeEntity saveAndFlush(SizeEntity sizeEntity);
}
