package webmobileshop.repositorty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webmobileshop.entity.BlackListEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlackListRepository extends JpaRepository<BlackListEntity, Long> {
    Optional<BlackListEntity> findByBlackListId(Long blackListId);
    List<BlackListEntity> findByUserErorr(String userErorr);
    List<BlackListEntity> findByUserid(String userId);
    void deleteByBlackListId(Long  blackListId);
    BlackListEntity saveAndFlush(BlackListEntity blackListEntity);
}
