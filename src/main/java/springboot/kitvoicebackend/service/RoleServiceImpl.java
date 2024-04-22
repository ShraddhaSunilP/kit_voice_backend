package springboot.kitvoicebackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.kitvoicebackend.entities.Role;
import springboot.kitvoicebackend.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleRepository roleRepository;

	@Override
	public Role addRole(Role role) {
		// TODO Auto-generated method stub
		roleRepository.save(role);
		return role;
	}

	@Override
	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	@Override
	public Optional<Role> getRoleById(int role_id) {
		// TODO Auto-generated method stub
		return roleRepository.findById(role_id);
		 
	}

	@Override
	public Role updateRole(int role_id, Role role) {
		// TODO Auto-generated method stub
		roleRepository.save(role);
		return role;
	}

	@Override
	public boolean deleteRole(int role_id) {
		Optional<Role> role = roleRepository.findById(role_id);
		if(role.isPresent()) {
			roleRepository.deleteById(role_id);
			return true;
		} else {
			return false;
		}
	}
	
}
