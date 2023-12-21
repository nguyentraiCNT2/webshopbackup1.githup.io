package webmobileshop.repositorty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webmobileshop.entity.CategoryItemEntity;
import webmobileshop.entity.CtegoryEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryItemRepository extends JpaRepository<CategoryItemEntity,Long> {
    Optional<CategoryItemEntity> findByCategoryItemId(Long categoryItemId);

    List<CategoryItemEntity> findByCategoryItemName(String categoryItemName);
    void deleteByCategoryItemId(Long  categoryItemId);

    CategoryItemEntity saveAndFlush(CategoryItemEntity categoryItemEntity);

}
