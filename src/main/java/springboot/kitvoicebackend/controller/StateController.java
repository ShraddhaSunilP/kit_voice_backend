package springboot.kitvoicebackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.kitvoicebackend.entities.State;
import springboot.kitvoicebackend.service.StateService;

@RestController
@RequestMapping("/state")
public class StateController {
	@Autowired
	StateService stateService;
	
	@PostMapping("/addState")
	public State addState(@RequestBody State state) {
		return stateService.addState(state);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllStates(){
		List<State> state = stateService.getAllStates();
		if(!state.isEmpty()) {
			return ResponseEntity.ok(state);
		} else {
			String errMsg ="No Records found";
			return new ResponseEntity<>(errMsg, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("{state_id}")
	public ResponseEntity<?> getStateById(@PathVariable int state_id){
		Optional<State> state = stateService.getStateById(state_id);
		if(state.isPresent()) {
			return ResponseEntity.ok(state.get());
		} else {
			String errMsg = "State With ID "+state_id+" is not found";
			return new ResponseEntity<>(errMsg, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("{state_id}")
	public State updateState(@PathVariable int state_id, @RequestBody State state) {
		return stateService.updateState(state_id, state);
	}
	
	@DeleteMapping("{state_id}")
	public ResponseEntity<?> deleteState(@PathVariable int state_id) {
		boolean isdeleted = stateService.deleteState(state_id);
		if(isdeleted) {
			String successMsg ="State With ID "+state_id+" is deleted";
			return ResponseEntity.ok(successMsg);
		} else {
			String errMsg ="State With ID "+state_id+" is not found";
			return new ResponseEntity<>(errMsg, HttpStatus.NOT_FOUND);
		}
	}

}






