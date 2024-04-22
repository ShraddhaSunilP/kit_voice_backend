package springboot.kitvoicebackend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Village {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int village_id;
	private String village_name;
	private String village_abbreviation;
	private int block_id;
	
	public Village() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Village(int village_id, String village_name, String village_abbreviation, int block_id) {
		super();
		this.village_id = village_id;
		this.village_name = village_name;
		this.village_abbreviation = village_abbreviation;
		this.block_id = block_id;
	}

	@Override
	public String toString() {
		return "Village [village_id=" + village_id + ", village_name=" + village_name + ", village_abbreviation="
				+ village_abbreviation + ", block_id=" + block_id + "]";
	}

	public int getVillage_id() {
		return village_id;
	}

	public void setVillage_id(int village_id) {
		this.village_id = village_id;
	}

	public String getVillage_name() {
		return village_name;
	}

	public void setVillage_name(String village_name) {
		this.village_name = village_name;
	}

	public String getVillage_abbreviation() {
		return village_abbreviation;
	}

	public void setVillage_abbreviation(String village_abbreviation) {
		this.village_abbreviation = village_abbreviation;
	}

	public int getBlock_id() {
		return block_id;
	}

	public void setBlock_id(int block_id) {
		this.block_id = block_id;
	}
}
