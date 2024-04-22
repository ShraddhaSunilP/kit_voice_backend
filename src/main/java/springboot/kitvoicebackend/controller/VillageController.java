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

import springboot.kitvoicebackend.entities.Village;
import springboot.kitvoicebackend.service.VillageService;

@RestController
@RequestMapping("/village")
public class VillageController {
	
	@Autowired
	VillageService villageService;
	
	@PostMapping("/addVillage")
	public Village addVillage(@RequestBody Village village) {
		return villageService.addVillage(village);
	}
	
	//GetAll
	@GetMapping("/getAll")
		public ResponseEntity<?> getAllVillage(){
			List<Village> vlg = villageService.getAllVillage();
			if(!vlg.isEmpty()) {
				return ResponseEntity.ok(vlg);
			} else {
				String emsg = "No Records Found";
				return new ResponseEntity<>(emsg, HttpStatus.NOT_FOUND);
			}
		}
			
	//Get Department By id
	@GetMapping("/{village_id}")
		public ResponseEntity<?> getVillageById(@PathVariable int village_id) {
			Optional<Village> village = villageService.getVillageById(village_id);
		        if (village.isPresent()) {
		            return ResponseEntity.ok(village.get());
		        } else {
		            String errorMessage = "Village with ID " + village_id + " not found.";
		            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
		        }
		}
	

	@PutMapping("/{village_id}")
	public Village updateVillage(@PathVariable int village_id, @RequestBody Village village) {
		return villageService.updateVillage(village_id, village);
	}
	
	//delete By Id
	@DeleteMapping("/{village_id}")
	public ResponseEntity<?> deleteVillage(@PathVariable int village_id) {
        boolean isdeleted = villageService.deleteVillage(village_id);
        if (isdeleted) {
        	String successMsg = "Village with ID " + village_id + " is deleted.";
            return ResponseEntity.ok(successMsg);
        } else {
            String errorMessage = "Village with ID " + village_id + " not found.";
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        }
	}

}
