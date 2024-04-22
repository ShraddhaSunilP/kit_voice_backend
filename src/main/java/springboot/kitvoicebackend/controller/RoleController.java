package springboot.kitvoicebackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.kitvoicebackend.entities.Role;
import springboot.kitvoicebackend.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
	@Autowired
	RoleService roleService;
	
	@PostMapping("/addRole")
	public Role addRole(@RequestBody Role role) {
		return roleService.addRole(role);
	}
	
	//GetAll
	@GetMapping("/getAll")
		public ResponseEntity<?> getAllRoles(){
			List<Role> role = roleService.getAllRoles();
			if(!role.isEmpty()) {
				return ResponseEntity.ok(role);
			} else {
				String emsg = "No Records Found";
				return new ResponseEntity<>(emsg, HttpStatus.NOT_FOUND);
			}
		}
			
	//Get Department By id
	@GetMapping("/{role_id}")
		public ResponseEntity<?> getRoleById(@PathVariable int role_id) {
			Optional<Role> user = roleService.getRoleById(role_id);
		        if (user.isPresent()) {
		            return ResponseEntity.ok(user.get());
		        } else {
		            String errorMessage = "Role with ID " + role_id + " not found.";
		            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
		        }
		}
	

	@PutMapping("/{role_id}")
	public Role updateRole(@PathVariable int role_id, @RequestBody Role role) {
		return roleService.updateRole(role_id, role);
	}
	
	//delete By Id
	@DeleteMapping("/{role_id}")
	public ResponseEntity<?> deleteRole(@PathVariable int role_id) {
        boolean isdeleted = roleService.deleteRole(role_id);
        if (isdeleted) {
        	String successMsg = "Role with ID " + role_id + " is deleted.";
            return ResponseEntity.ok(successMsg);
        } else {
            String errorMessage = "Role with ID " + role_id + " not found.";
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        }
	}

	
}
