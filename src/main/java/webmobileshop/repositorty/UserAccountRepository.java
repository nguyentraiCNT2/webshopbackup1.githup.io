package webmobileshop.repositorty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webmobileshop.dto.ImagesDTO;
import webmobileshop.dto.RoleDTO;
import webmobileshop.entity.ImagesEntity;
import webmobileshop.entity.RoleEntity;
import webmobileshop.entity.UserAccountEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccountEntity, String> {
    Optional<UserAccountEntity>  findByuserId(String userId);

    List<UserAccountEntity> findByuserName(String userName);

    List<UserAccountEntity> findByPassword(String password);

    List<UserAccountEntity> findByfristName(String fristName);

    List<UserAccountEntity> findUserByLastName(String lastName);

    List<UserAccountEntity> findByemail(String email);

    List<UserAccountEntity> findByphone(String phone);

    List<UserAccountEntity> findBygenDer(String genDer);

    List<UserAccountEntity> findBystatus(boolean status);

    List<UserAccountEntity> findByblockUser(boolean blockUser);

    List<UserAccountEntity> findByImages(ImagesDTO images);

    List<UserAccountEntity> findByRoleDTO(RoleDTO roleDTO);

    void deleteByuserId(String  userId);

    UserAccountEntity saveAndFlush(UserAccountEntity userAccountEntity);
}
