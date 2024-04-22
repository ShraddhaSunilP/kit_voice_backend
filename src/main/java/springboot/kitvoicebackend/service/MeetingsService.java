package springboot.kitvoicebackend.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import springboot.kitvoicebackend.entities.Meetings;

public interface MeetingsService {

	Meetings createMeeting(Meetings meeting);

	Optional<Meetings> getMeetingById(int id);

	List<Map<String, Object>> getMeetingDetailsWithUserDetails();

}
