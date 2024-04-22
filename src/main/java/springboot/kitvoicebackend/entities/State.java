package springboot.kitvoicebackend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class State {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int state_id;
	private String state_name;
	private String state_abbreviation;
	
	public State() {
		super();
		// TODO Auto-generated constructor stub
	}

	public State(int state_id, String state_name, String state_abbreviation) {
		super();
		this.state_id = state_id;
		this.state_name = state_name;
		this.state_abbreviation = state_abbreviation;
	}

	@Override
	public String toString() {
		return "State [state_id=" + state_id + ", state_name=" + state_name + ", state_abbreviation="
				+ state_abbreviation + "]";
	}

	public int getState_id() {
		return state_id;
	}

	public void setState_id(int state_id) {
		this.state_id = state_id;
	}

	public String getState_name() {
		return state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

	public String getState_abbreviation() {
		return state_abbreviation;
	}

	public void setState_abbreviation(String state_abbreviation) {
		this.state_abbreviation = state_abbreviation;
	}
}
