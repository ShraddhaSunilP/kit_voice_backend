package springboot.kitvoicebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.kitvoicebackend.entities.SubDepartment;

@Repository
public interface SubDepartmentRepository extends JpaRepository<SubDepartment, Integer> {

}
