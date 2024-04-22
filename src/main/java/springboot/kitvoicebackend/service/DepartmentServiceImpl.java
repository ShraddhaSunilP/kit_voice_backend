package springboot.kitvoicebackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.kitvoicebackend.entities.Department;
import springboot.kitvoicebackend.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	// create department
		@Override
		public Department createDepartment(Department department) {
			departmentRepository.save(department);
			return department;
		}
		
		@Override
		public List<Department> getAllDepartments() {
			return departmentRepository.findAll();
		}
		
		//Get By Id
		@Override
		public Optional<Department> getDeptById(int dept_id) {
			return departmentRepository.findById(dept_id);
		}
		
		//Update by Id
		@Override
		public Department updateDept(int dept_id, Department dept) {
			departmentRepository.save(dept);
			return dept;
		}
				
		//Delete Department By Id
		@Override
		public boolean deleteDept(int dept_id) {
			Optional<Department> department = departmentRepository.findById(dept_id);
			if (department.isPresent()) {
	            departmentRepository.deleteById(dept_id);
	            return true; 
	        } else {
	            return false; 
	        }
		}
}
