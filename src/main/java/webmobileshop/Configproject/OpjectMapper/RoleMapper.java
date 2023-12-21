package webmobileshop.Configproject.OpjectMapper;


import org.springframework.stereotype.Component;


import org.modelmapper.ModelMapper;
import webmobileshop.dto.RoleDTO;
import webmobileshop.entity.RoleEntity;

@Component
public class RoleMapper {

	  private final ModelMapper modelMapper;
		
	    public RoleMapper(ModelMapper modelMapper) {
			this.modelMapper = modelMapper;
		}
	    public RoleEntity mapToEntity(RoleDTO dto) {
                RoleEntity entity =  modelMapper.map(dto, RoleEntity.class);
                return entity;
            }
            public RoleDTO mapToDTO(RoleEntity entity) {
                RoleDTO dto =  modelMapper.map(entity, RoleDTO.class);
                return dto;
	    }
    public RoleDTO toDTO(RoleEntity entity) {
        RoleDTO dto = new RoleDTO();
        dto.setRoleId(entity.getRoleId());
        dto.setRoleName(entity.getRoleName());
        return dto;
    }

    public RoleEntity toEntity(RoleDTO dto) {
        RoleEntity entity = new RoleEntity();
        entity.setRoleId(dto.getRoleId());
        entity.setRoleName(dto.getRoleName());
        return entity;
    }
}
