package springboot.kitvoicebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.kitvoicebackend.entities.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
