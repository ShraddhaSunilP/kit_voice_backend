package springboot.kitvoicebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.kitvoicebackend.entities.Village;

@Repository
public interface VillageRepository extends JpaRepository<Village, Integer> {

}
