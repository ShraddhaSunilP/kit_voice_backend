package springboot.kitvoicebackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.kitvoicebackend.entities.District;
import springboot.kitvoicebackend.repository.DistrictRepository;

@Service
public class DistrictServiceImpl implements DistrictService {
	@Autowired
	DistrictRepository districtRepository;

	@Override
	public District addDist(District district) {
		districtRepository.save(district);
		return district;
	}

	@Override
	public List<District> getAllDistrict() {
		return districtRepository.findAll();
	}

	@Override
	public Optional<District> getDistrictById(int district_id) {
		return districtRepository.findById(district_id);
	}

	@Override
	public District upadateDistrict(int district_id, District district) {
		districtRepository.save(district);
		return district;
	}

	@Override
	public boolean deleteDistrict(int district_id) {
		Optional<District> dist = districtRepository.findById(district_id);
		if(dist.isPresent()) {
			districtRepository.deleteById(district_id);
			return true;
		} else {
			return true;
		}
	}
}
