package springboot.kitvoicebackend.service;

import java.util.List;
import java.util.Optional;

import springboot.kitvoicebackend.entities.User;

public interface UserService {
	
	User addUser(User user);

	List<User> getAllUserss();

	Optional<User> getDeptById(int user_id);

	User updateUser(int user_id, User user);

	boolean deleteUser(int user_id);
}
