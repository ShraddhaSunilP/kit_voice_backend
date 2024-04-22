package springboot.kitvoicebackend.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.kitvoicebackend.entities.Meetings;
import springboot.kitvoicebackend.entities.User;
import springboot.kitvoicebackend.repository.MeetingsRepository;
import springboot.kitvoicebackend.repository.UserRepository;

@Service
public class MeetingsServiceImpl implements MeetingsService {
	
	@Autowired
	MeetingsRepository meetingsRepository;
	
	@Autowired
    private UserRepository userRepository;

	@Override
	public Meetings createMeeting(Meetings meeting) {
		meetingsRepository.save(meeting);
		return meeting;
	}

	@Override
	public Optional<Meetings> getMeetingById(int id) {
		return meetingsRepository.findById(id); 
	}

	@Override
	public List<Map<String, Object>> getMeetingDetailsWithUserDetails() {
		List<Map<String, Object>> meetingDetails = meetingsRepository.getMeetingDetailsWithUserDetails();
		List<Map<String, Object>> result = new ArrayList<>();

		for (Map<String, Object> meeting : meetingDetails){
		// Check if the meeting already exists in the result list
			boolean meetingExists = result.stream()
	                .anyMatch(m -> m.get("id").equals(meeting.get("id")));
	
			if (!meetingExists) {
	            Map<String, Object> meetingWithAttendees = new HashMap<>();
	            List<Map<String, Object>> attendeeDetails = new ArrayList<>();
	           
	        // Add common meeting details
	        meetingWithAttendees.put("id", meeting.get("id"));
	        meetingWithAttendees.put("meeting_url", meeting.get("meeting_url"));
	        meetingWithAttendees.put("meeting_time", meeting.get("meeting_time"));
	        meetingWithAttendees.put("meeting_organizer", meeting.get("meeting_organizer"));
	        meetingWithAttendees.put("author_name", meeting.get("author_name"));
	        meetingWithAttendees.put("author_email", meeting.get("author_email"));
	        meetingWithAttendees.put("author_phone", meeting.get("author_phone"));
	        meetingWithAttendees.put("author_password", meeting.get("author_password"));
	        meetingWithAttendees.put("author_role", meeting.get("author_role"));
	        meetingWithAttendees.put("meeting_attendee", meeting.get("meeting_attendee"));
	
	       // Process attendee details
	        String attendeeString = (String) meeting.get("meeting_attendee");
            if (attendeeString != null) {
                // Remove brackets [ ] from the attendee string
                attendeeString = attendeeString.substring(1, attendeeString.length() - 1);

                // Split the attendee string by comma
                String[] attendeeIds = attendeeString.split(", ");

                for (String attendeeId : attendeeIds) {
                    // Retrieve attendee details from the database using attendeeId
                    User attendee = userRepository.findById(Integer.parseInt(attendeeId)).orElse(null);
                    if (attendee != null) {
                        Map<String, Object> attendeeDetail = new HashMap<>();
                        attendeeDetail.put("user_id", attendee.getUser_id());
                        attendeeDetail.put("user_name", attendee.getUser_name());
                        attendeeDetail.put("user_email", attendee.getUser_email());
                        attendeeDetail.put("user_phone", attendee.getUser_phone()); 
                        attendeeDetail.put("user_password", attendee.getUser_password());
                        attendeeDetail.put("user_role", attendee.getUser_role ());
                        attendeeDetails.add(attendeeDetail);
                    }
                }
            }
            // Add attendee details to the meetingWithAttendees map
            meetingWithAttendees.put("attendee_details", attendeeDetails);

            // Add the meetingWithAttendees map to the result list
            result.add(meetingWithAttendees);
        }
    }

    return result;
	}
}

