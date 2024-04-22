package springboot.kitvoicebackend.service;

import java.util.List;
import java.util.Optional;

import springboot.kitvoicebackend.entities.Department;

public interface DepartmentService {
		//Create
		Department createDepartment(Department department);
		
		//GetAll
		List<Department> getAllDepartments();

		//GetDeptById
		Optional<Department> getDeptById(int dept_id);

		//UpdateDeptById
		Department updateDept(int dept_id, Department dept);

		//DeleteDeptById
		boolean deleteDept(int dept_id);

}
