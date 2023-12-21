package webmobileshop.repositorty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webmobileshop.entity.UserAccountEntity;
import webmobileshop.entity.UserTokenEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserTokenRepository extends JpaRepository<UserTokenEntity, Long > {

    Optional<UserTokenEntity> findByUserTokenId(Long userTokenId);

    Optional<UserTokenEntity> findByMainToken(String mainToken);

    Optional<UserTokenEntity> findByReplaceToken(String replaceToken);
   List<UserTokenEntity>  findByUserUserId(String userId);
    void deleteByUserTokenId(Long  userId);

    UserTokenEntity saveAndFlush(UserTokenEntity userTokenEntity);
}
