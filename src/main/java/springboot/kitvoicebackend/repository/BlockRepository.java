package springboot.kitvoicebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.kitvoicebackend.entities.Block;

@Repository
public interface BlockRepository extends JpaRepository<Block, Integer> {

}
