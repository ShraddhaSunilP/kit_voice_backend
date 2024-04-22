package springboot.kitvoicebackend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SubDepartment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int subdept_id;
	private String block_abbreviation;
	
	public SubDepartment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public SubDepartment(int subdept_id, String block_abbreviation) {
		super();
		this.subdept_id = subdept_id;
		this.block_abbreviation = block_abbreviation;
	}
	
	
	@Override
	public String toString() {
		return "SubDepartment [subdept_id=" + subdept_id + ", block_abbreviation=" + block_abbreviation + "]";
	}
	
	
	public int getSubdept_id() {
		return subdept_id;
	}
	public void setSubdept_id(int subdept_id) {
		this.subdept_id = subdept_id;
	}
	public String getBlock_abbreviation() {
		return block_abbreviation;
	}
	public void setBlock_abbreviation(String block_abbreviation) {
		this.block_abbreviation = block_abbreviation;
	}
	
}
