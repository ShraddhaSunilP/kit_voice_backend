package springboot.kitvoicebackend.service;

import java.util.List;
import java.util.Optional;

import springboot.kitvoicebackend.entities.Role;

public interface RoleService {

	Role addRole(Role role);

	List<Role> getAllRoles();

	Optional<Role> getRoleById(int role_id);

	Role updateRole(int role_id, Role role);

	boolean deleteRole(int role_id);

}
