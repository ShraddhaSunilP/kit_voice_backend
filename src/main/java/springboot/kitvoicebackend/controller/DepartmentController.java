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

import springboot.kitvoicebackend.entities.Department;
import springboot.kitvoicebackend.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;

		//Create Department 
		@PostMapping("/createDept")
		public Department createDepartment(@RequestBody Department department) {
			return departmentService.createDepartment(department);
		}
		
		//GetAll
		@GetMapping("/getAll")
		public ResponseEntity<?> getAllDepartments(){
			List<Department> dept = departmentService.getAllDepartments();
			if(!dept.isEmpty()) {
				return ResponseEntity.ok(dept);
			} else {
				String emsg = "No Records Found";
				return new ResponseEntity<>(emsg, HttpStatus.NOT_FOUND);
			}
		}
		
		//Get Department By id
		@GetMapping("/{dept_id}")
	    public ResponseEntity<?> getDeptById(@PathVariable int dept_id) {
	        Optional<Department> department = departmentService.getDeptById(dept_id);
	        if (department.isPresent()) {
	            return ResponseEntity.ok(department.get());
	        } else {
	            String errorMessage = "Department with ID " + dept_id + " not found.";
	            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	        }
		}
		
		//updated By Id
		@PutMapping("/{dept_id}")
		public Department updateDept(@PathVariable int dept_id, @RequestBody Department dept) {
			return departmentService.updateDept(dept_id, dept);
		}

//		
		//Delete Dept By Id
		@DeleteMapping("/{dept_id}")
		public ResponseEntity<?> deleteDept(@PathVariable int dept_id) {
	        boolean isdeleted = departmentService.deleteDept(dept_id);
	        if (isdeleted) {
	        	String successMsg = "Department with ID " + dept_id + " is deleted.";
	            return ResponseEntity.ok(successMsg);
	        } else {
	            String errorMessage = "Department with ID " + dept_id + " not found.";
	            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	        }
		}
}
