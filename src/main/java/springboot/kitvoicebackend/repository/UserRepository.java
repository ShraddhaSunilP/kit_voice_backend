package springboot.kitvoicebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.kitvoicebackend.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
