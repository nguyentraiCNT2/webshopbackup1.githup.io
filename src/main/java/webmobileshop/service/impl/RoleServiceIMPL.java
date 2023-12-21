package webmobileshop.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webmobileshop.Configproject.OpjectMapper.RoleMapper;
import webmobileshop.dto.RoleDTO;
import webmobileshop.entity.RoleEntity;
import webmobileshop.repositorty.RoleRepository;
import webmobileshop.service.RoleServive;

@Service
public class RoleServiceIMPL implements RoleServive {
	@Autowired
	private RoleRepository roleRepository;
	private final RoleMapper roleMapper;
	private ModelMapper modelMapper;

	@Autowired
	public RoleServiceIMPL(RoleRepository roleRepository, RoleMapper roleMapper, ModelMapper modelMapper) {
		super();
		this.roleRepository = roleRepository;
		this.roleMapper = roleMapper;
		this.modelMapper = modelMapper;
	}

	@Override
	public RoleDTO getRoleByRoleId(Long roleId) {
		RoleEntity roleEntity = roleRepository.findByRoleId(roleId)
				.orElseThrow(() -> new RuntimeException("Không tìm thấy Quyền"));
		return modelMapper.map(roleEntity, RoleDTO.class);
	}

	public void createRole(RoleDTO roleDTO) {
		if (roleDTO != null) {
			String name = roleDTO.getRoleName();
			if (roleDTO.getRoleName() != null) {
				RoleEntity roleEntity = roleMapper.mapToEntity(roleDTO);
				if (roleEntity.getRoleName() != null) {
					if (roleEntity != null) {

						roleRepository.save(roleEntity);
					} else {
						System.err.println("Không có dữ liệu về Quyền người dùng, kết nối thất bại");
					}
				} else {
					System.err.println("ten chua duoc chuyen ve Data: " + roleEntity.getRoleName() );
				}
			} else {
				System.err.println("ten chua duoc chuyen ve Data: " + roleDTO.getRoleName());
			}
		} else {
			System.err.println("Không tìm thấy thông tin Quyền người dùng trong dữ liệu");
		}
	}

	@Override
	public void updateRole(RoleDTO roleDTO) {

		RoleEntity existingRole = roleRepository.findByRoleId(roleDTO.getRoleId())
				.orElseThrow(() -> new RuntimeException("Không tìm thấy Quyền"));
		modelMapper.map(roleDTO, existingRole);
		roleRepository.save(existingRole);
	}

	@Override
	public void deleteRole(Long roleId) {
		roleRepository.deleteByRoleId(roleId);

	}

	@Override
	public List<RoleDTO> getAllRole() {
		List<RoleEntity> role = roleRepository.findAll();
		return role.stream().map(roles -> modelMapper.map(roles, RoleDTO.class)).collect(Collectors.toList());

	}

	@Override
	public List<RoleDTO> getRoleName(String roleName) {
		List<RoleEntity> role = roleRepository.findByRoleName(roleName);
		return role.stream().map(roles -> modelMapper.map(roles, RoleDTO.class)).collect(Collectors.toList());
	}

}
