package springboot.kitvoicebackend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Block {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int block_id;
	private String block_name;
	private String block_abbreviation;
	private int district_id;
	
	public Block() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Block(int block_id, String block_name, String block_abbreviation, int district_id) {
		super();
		this.block_id = block_id;
		this.block_name = block_name;
		this.block_abbreviation = block_abbreviation;
		this.district_id = district_id;
	}

	@Override
	public String toString() {
		return "Block [block_id=" + block_id + ", block_name=" + block_name + ", block_abbreviation="
				+ block_abbreviation + ", district_id=" + district_id + "]";
	}

	public int getBlock_id() {
		return block_id;
	}

	public void setBlock_id(int block_id) {
		this.block_id = block_id;
	}

	public String getBlock_name() {
		return block_name;
	}

	public void setBlock_name(String block_name) {
		this.block_name = block_name;
	}

	public String getBlock_abbreviation() {
		return block_abbreviation;
	}

	public void setBlock_abbreviation(String block_abbreviation) {
		this.block_abbreviation = block_abbreviation;
	}

	public int getDistrict_id() {
		return district_id;
	}

	public void setDistrict_id(int district_id) {
		this.district_id = district_id;
	}
}
