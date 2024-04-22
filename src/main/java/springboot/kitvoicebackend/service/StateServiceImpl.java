package springboot.kitvoicebackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.kitvoicebackend.entities.State;
import springboot.kitvoicebackend.repository.StateRepository;

@Service
public class StateServiceImpl implements StateService {
	@Autowired
	StateRepository stateRepository;

	@Override
	public State addState(State state) {
		// TODO Auto-generated method stub
		stateRepository.save(state);
		return state;
	}

	@Override
	public List<State> getAllStates() {
		// TODO Auto-generated method stub
		return stateRepository.findAll();
	}

	@Override
	public Optional<State> getStateById(int state_id) {
		// TODO Auto-generated method stub
		return stateRepository.findById(state_id);
	}

	@Override
	public State updateState(int state_id, State state) {
		// TODO Auto-generated method stub
		stateRepository.save(state);
		return state;
	}

	@Override
	public boolean deleteState(int state_id) {
		Optional<State> state = stateRepository.findById(state_id);
		if(state.isPresent()) {
			stateRepository.deleteById(state_id);
			return true;
		} else {
			return false;
		}
	}
	
}
