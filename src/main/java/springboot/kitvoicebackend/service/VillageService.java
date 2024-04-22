package springboot.kitvoicebackend.service;

import java.util.List;
import java.util.Optional;

import springboot.kitvoicebackend.entities.Village;

public interface VillageService {

	Village addVillage(Village village);

	List<Village> getAllVillage();

	Optional<Village> getVillageById(int village_id);

	Village updateVillage(int village_id, Village village);

	boolean deleteVillage(int village_id);

}
