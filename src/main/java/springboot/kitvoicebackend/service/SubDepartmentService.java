package springboot.kitvoicebackend.service;

import java.util.List;
import java.util.Optional;

import springboot.kitvoicebackend.entities.SubDepartment;

public interface SubDepartmentService {

	SubDepartment addSubDept(SubDepartment subDept);

	List<SubDepartment> getAllSubDept();

	Optional<SubDepartment> getSubDeptById(int subdept_id);

	SubDepartment updateSubDept(SubDepartment subDept);

	boolean deleteSubDept(int subdept_id);

}
