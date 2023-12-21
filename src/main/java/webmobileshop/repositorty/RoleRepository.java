package webmobileshop.repositorty;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webmobileshop.entity.RoleEntity;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long>{

	Optional<RoleEntity> findByRoleId(Long roleId);
    
    List<RoleEntity> findByRoleName(String roleName);
    
    void deleteByRoleId(Long roleId);
    
    RoleEntity saveAndFlush(RoleEntity roleEntity);
}
