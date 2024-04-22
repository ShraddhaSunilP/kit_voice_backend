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

import springboot.kitvoicebackend.entities.SubDepartment;
import springboot.kitvoicebackend.service.SubDepartmentService;

@RestController
@RequestMapping("/subDept")
public class SubDepartmentController {
	@Autowired
	SubDepartmentService subDeptService;
	
	@PostMapping("/addSubDept")
	public SubDepartment addSubDept(@RequestBody SubDepartment SubDept) {
		return subDeptService.addSubDept(SubDept);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllSubDept(){
		List<SubDepartment> subdept = subDeptService.getAllSubDept();
		if(!subdept.isEmpty()) {
			return ResponseEntity.ok(subdept);
		} else {
			String errMsg = "No Records found...";
			return new ResponseEntity<>(errMsg, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{subdept_id}")
	public ResponseEntity<?> getSubDeptById(@PathVariable int subdept_id){
		Optional<SubDepartment> subdept = subDeptService.getSubDeptById(subdept_id);
		if(subdept.isPresent()) {
			return ResponseEntity.ok(subdept.get());
		} else {
			String errMsg="SubDepartment with ID "+subdept_id+" is not found";
			return new ResponseEntity<>(errMsg, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{subdept_id}")
	public SubDepartment updateSubDept(@PathVariable int subdept_id, @RequestBody SubDepartment SubDept) {
		return subDeptService.updateSubDept(SubDept);
	}
	
	
	@DeleteMapping("/{subdept_id}")
	public ResponseEntity<?> deleteSubDept(@PathVariable int subdept_id){
		boolean deleted = subDeptService.deleteSubDept(subdept_id);
		if(deleted) {
			String succMsg = "SubDepartment with ID "+subdept_id+" is deleted";
			return ResponseEntity.ok(succMsg);
		} else {
			String errMsg = "SubDepartment with ID "+subdept_id+" is not found";
			return new ResponseEntity<>(errMsg, HttpStatus.NOT_FOUND);
		}
	}
}




