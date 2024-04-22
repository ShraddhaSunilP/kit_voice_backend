package springboot.kitvoicebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.kitvoicebackend.entities.District;

@Repository
public interface DistrictRepository extends JpaRepository<District, Integer> {

}
