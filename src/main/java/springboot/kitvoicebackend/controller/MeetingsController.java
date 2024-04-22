package springboot.kitvoicebackend.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.kitvoicebackend.entities.Meetings;
import springboot.kitvoicebackend.service.MeetingsService;
@RestController
@RequestMapping("/kit_voice")
public class MeetingsController {
 
	@Autowired
	MeetingsService meetingsService;
	
	// Create meeting
	@PostMapping("/createMeeting")
	public Meetings createMeeting(@RequestBody Meetings meeting) {
		return meetingsService.createMeeting(meeting);
	}
	
	//Get meeting By user_id
	@GetMapping("/{id}")
	public ResponseEntity<?> getMeetingById(@PathVariable int id){
		Optional<Meetings> meetings = meetingsService.getMeetingById(id);
		if(meetings.isPresent()) {
			return ResponseEntity.ok(meetings.get());
		} else {
			String errMsg = "Meeting with user_id "+id+" is not found";
			return new ResponseEntity<> (errMsg, HttpStatus.NOT_FOUND);
		}
	}
	
	//Get all meetings list
	@GetMapping("/meetings")
	public List<Map<String, Object>> getAllMeetings(){
		return meetingsService.getMeetingDetailsWithUserDetails();
	}
}
