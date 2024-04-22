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

import springboot.kitvoicebackend.entities.User;
import springboot.kitvoicebackend.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	//GetAll
	@GetMapping("/getAll")
		public ResponseEntity<?> getAllUserss(){
			List<User> user = userService.getAllUserss();
			if(!user.isEmpty()) {
				return ResponseEntity.ok(user);
			} else {
				String emsg = "No Records Found";
				return new ResponseEntity<>(emsg, HttpStatus.NOT_FOUND);
			}
		}
			
	//Get Department By id
	@GetMapping("/{user_id}")
		public ResponseEntity<?> getDeptById(@PathVariable int user_id) {
			Optional<User> user = userService.getDeptById(user_id);
		        if (user.isPresent()) {
		            return ResponseEntity.ok(user.get());
		        } else {
		            String errorMessage = "Department with ID " + user_id + " not found.";
		            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
		        }
		}
	

	@PutMapping("/{user_id}")
	public User updateUser(@PathVariable int user_id, @RequestBody User user) {
		return userService.updateUser(user_id, user);
	}
	
	//delete By Id
	@DeleteMapping("/{user_id}")
	public ResponseEntity<?> deleteUser(@PathVariable int user_id) {
        boolean isdeleted = userService.deleteUser(user_id);
        if (isdeleted) {
        	String successMsg = "Department with ID " + user_id + " is deleted.";
            return ResponseEntity.ok(successMsg);
        } else {
            String errorMessage = "Department with ID " + user_id + " not found.";
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        }
	}

}
