package springboot.kitvoicebackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.kitvoicebackend.entities.Village;
import springboot.kitvoicebackend.repository.VillageRepository;

@Service
public class VillageServiceImpl implements VillageService {
	
	@Autowired 
	VillageRepository villageRepository;

	@Override
	public Village addVillage(Village village) {
		villageRepository.save(village);	
		return village;
	}

	@Override
	public List<Village> getAllVillage() {
		return villageRepository.findAll();
	}

	@Override
	public Optional<Village> getVillageById(int village_id) {
		return villageRepository.findById(village_id);
	}

	@Override
	public Village updateVillage(int village_id, Village village) {
		 villageRepository.save(village);
		 return village;
	}

	@Override
	public boolean deleteVillage(int village_id) {
		Optional<Village> vlg = villageRepository.findById(village_id);
		if( vlg.isPresent()) {
			villageRepository.deleteById(village_id);
			return true; 
		} else {
			return false;
		}
	}

}
