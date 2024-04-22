package springboot.kitvoicebackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.kitvoicebackend.entities.User;
import springboot.kitvoicebackend.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User addUser(User user) {
		userRepository.save(user);
		return user;
	}

	@Override
	public List<User> getAllUserss() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getDeptById(int user_id) {
		return userRepository.findById(user_id);
	}

	@Override
	public User updateUser(int user_id, User user) {
		userRepository.save(user);
		return user;
	}

	@Override
	public boolean deleteUser(int user_id) {
		Optional<User> department = userRepository.findById(user_id);
		if (department.isPresent()) {
			userRepository.deleteById(user_id);
            return true; 
        } else {
            return false; 
        }
	}
}
