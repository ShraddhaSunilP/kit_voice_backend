package springboot.kitvoicebackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.kitvoicebackend.entities.SubDepartment;
import springboot.kitvoicebackend.repository.SubDepartmentRepository;

@Service
public class SubDepartmentServiceImpl implements SubDepartmentService {
	@Autowired
	SubDepartmentRepository subDeptRepo;

	@Override
	public SubDepartment addSubDept(SubDepartment subDept) {
		// TODO Auto-generated method stub
		subDeptRepo.save(subDept);
		return subDept;
	}

	@Override
	public List<SubDepartment> getAllSubDept() {
		// TODO Auto-generated method stub
		return subDeptRepo.findAll();
	}

	@Override
	public Optional<SubDepartment> getSubDeptById(int subdept_id) {
		// TODO Auto-generated method stub
		return subDeptRepo.findById(subdept_id);
	}

	@Override
	public SubDepartment updateSubDept(SubDepartment subDept) {
		// TODO Auto-generated method stub
		subDeptRepo.save(subDept);
		return subDept;
	}

	@Override
	public boolean deleteSubDept(int subdept_id) {
		// TODO Auto-generated method stub
		Optional<SubDepartment> subdept = subDeptRepo.findById(subdept_id);
		if(subdept.isPresent()) {
			 subDeptRepo.deleteById(subdept_id);
			 return true;
		} else {
			return false;
		}
	}
}
