package webmobileshop.repositorty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webmobileshop.entity.CtegoryEntity;
import webmobileshop.entity.UserAddressEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CtegoryEntity, Long> {
    Optional<CtegoryEntity> findByCategoryId(Long categoryId);

    List<CtegoryEntity> findByCategoryName(String categoryName);
    void deleteByCategoryId(Long  categoryId);

    CtegoryEntity saveAndFlush(CtegoryEntity ctegoryEntity);

}
