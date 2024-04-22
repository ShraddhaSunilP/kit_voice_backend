package springboot.kitvoicebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.kitvoicebackend.entities.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
