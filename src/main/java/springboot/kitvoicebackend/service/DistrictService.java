package springboot.kitvoicebackend.service;

import java.util.List;
import java.util.Optional;

import springboot.kitvoicebackend.entities.District;

public interface DistrictService {

	District addDist(District district);

	List<District> getAllDistrict();

	Optional<District> getDistrictById(int district_id);

	District upadateDistrict(int district_id, District district);

	boolean deleteDistrict(int district_id);

}
