package springboot.kitvoicebackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.kitvoicebackend.entities.District;
import springboot.kitvoicebackend.service.DistrictService;

@RestController
@RequestMapping("/district")
public class DistrictController {
	@Autowired
	DistrictService districtService;
	
	@PostMapping("/addDistrict")
	public District addDist(@RequestBody District district) {
		return districtService.addDist(district);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllDistrict(){
		List<District> dist = districtService.getAllDistrict();
		if(!dist.isEmpty()) {
			return ResponseEntity.ok(dist);
		} else {
			String errMsg = "No Records Found";
			return new ResponseEntity<>(errMsg, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{district_id}")
	public ResponseEntity<?> getDistrictById(@PathVariable int district_id){
		Optional<District> dist = districtService.getDistrictById(district_id);
		if(dist.isPresent()) {
			return ResponseEntity.ok(dist.get());
		} else {
			String errMsg = "District with ID "+district_id+" is not found";
			return new ResponseEntity<>(errMsg, HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PutMapping("/{district_id}")
	public District upadateDistrict(@PathVariable int district_id, @RequestBody District district) {
		return districtService.upadateDistrict(district_id,district);
	}
	
	
	
	@DeleteMapping("/{district_id}")
	public ResponseEntity<?> deleteDistrict(@PathVariable int district_id){
		boolean isdeleted = districtService.deleteDistrict(district_id);
		if(isdeleted) {
			String SuccMsg = "District with ID "+district_id+" is deleted";
			return ResponseEntity.ok(SuccMsg);
		} else {
			String errMsg = "District with ID "+district_id+" is not found";
			return new ResponseEntity<>(errMsg, HttpStatus.NOT_FOUND);
		}
	}
}


