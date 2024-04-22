package springboot.kitvoicebackend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int dept_id;
	private String dept_name;
	private int village_id;
	private int block_id;
	private int district_id;
	private int state_id;
	private int dept_head_id;
	private String dept_head_name;
	private String dept_head_email;
	private String dept_head_phoneNo;
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(int dept_id, String dept_name, int village_id, int block_id, int district_id, int state_id,
			int dept_head_id, String dept_head_name, String dept_head_email, String dept_head_phoneNo) {
		super();
		this.dept_id = dept_id;
		this.dept_name = dept_name;
		this.village_id = village_id;
		this.block_id = block_id;
		this.district_id = district_id;
		this.state_id = state_id;
		this.dept_head_id = dept_head_id;
		this.dept_head_name = dept_head_name;
		this.dept_head_email = dept_head_email;
		this.dept_head_phoneNo = dept_head_phoneNo;
	}

	@Override
	public String toString() {
		return "Department [dept_id=" + dept_id + ", dept_name=" + dept_name + ", village_id=" + village_id
				+ ", block_id=" + block_id + ", district_id=" + district_id + ", state_id=" + state_id
				+ ", dept_head_id=" + dept_head_id + ", dept_head_name=" + dept_head_name + ", dept_head_email="
				+ dept_head_email + ", dept_head_phoneNo=" + dept_head_phoneNo + "]";
	}

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public int getVillage_id() {
		return village_id;
	}

	public void setVillage_id(int village_id) {
		this.village_id = village_id;
	}

	public int getBlock_id() {
		return block_id;
	}

	public void setBlock_id(int block_id) {
		this.block_id = block_id;
	}

	public int getDistrict_id() {
		return district_id;
	}

	public void setDistrict_id(int district_id) {
		this.district_id = district_id;
	}

	public int getState_id() {
		return state_id;
	}

	public void setState_id(int state_id) {
		this.state_id = state_id;
	}

	public int getDept_head_id() {
		return dept_head_id;
	}

	public void setDept_head_id(int dept_head_id) {
		this.dept_head_id = dept_head_id;
	}

	public String getDept_head_name() {
		return dept_head_name;
	}

	public void setDept_head_name(String dept_head_name) {
		this.dept_head_name = dept_head_name;
	}

	public String getDept_head_email() {
		return dept_head_email;
	}

	public void setDept_head_email(String dept_head_email) {
		this.dept_head_email = dept_head_email;
	}

	public String getDept_head_phoneNo() {
		return dept_head_phoneNo;
	}

	public void setDept_head_phoneNo(String dept_head_phoneNo) {
		this.dept_head_phoneNo = dept_head_phoneNo;
	}
	
}
