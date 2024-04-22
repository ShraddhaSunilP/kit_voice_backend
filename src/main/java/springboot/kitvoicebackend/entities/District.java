package springboot.kitvoicebackend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class District {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int district_id;
	private String district_name;
	private String district_abbreviation;
	private int state_id;
	
	public District() {
		super();
		// TODO Auto-generated constructor stub
	}

	public District(int district_id, String district_name, String district_abbreviation, int state_id) {
		super();
		this.district_id = district_id;
		this.district_name = district_name;
		this.district_abbreviation = district_abbreviation;
		this.state_id = state_id;
	}

	@Override
	public String toString() {
		return "District [district_id=" + district_id + ", district_name=" + district_name + ", district_abbreviation="
				+ district_abbreviation + ", state_id=" + state_id + "]";
	}

	public int getDistrict_id() {
		return district_id;
	}

	public void setDistrict_id(int district_id) {
		this.district_id = district_id;
	}

	public String getDistrict_name() {
		return district_name;
	}

	public void setDistrict_name(String district_name) {
		this.district_name = district_name;
	}

	public String getDistrict_abbreviation() {
		return district_abbreviation;
	}

	public void setDistrict_abbreviation(String district_abbreviation) {
		this.district_abbreviation = district_abbreviation;
	}

	public int getState_id() {
		return state_id;
	}

	public void setState_id(int state_id) {
		this.state_id = state_id;
	}
}
