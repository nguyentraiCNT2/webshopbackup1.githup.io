package webmobileshop.repositorty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webmobileshop.entity.UserAddressEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddressEntity, Long> {
    Optional<UserAddressEntity> findByUserAddressId(Long userAddressId);
    List<UserAddressEntity> findByUserId(String userId);
    void deleteByUserAddressId(Long  userAddressId);

    UserAddressEntity saveAndFlush(UserAddressEntity userAddressEntity);
}
