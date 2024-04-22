package springboot.kitvoicebackend.service;

import java.util.List;
import java.util.Optional;

import springboot.kitvoicebackend.entities.State;

public interface StateService {

	State addState(State state);

	List<State> getAllStates();

	Optional<State> getStateById(int state_id);

	State updateState(int state_id, State state);

	boolean deleteState(int state_id);

}
