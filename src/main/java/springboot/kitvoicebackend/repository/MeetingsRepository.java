package springboot.kitvoicebackend.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import springboot.kitvoicebackend.entities.Meetings;

@Repository
public interface MeetingsRepository extends JpaRepository<Meetings, Integer> {
	
	@Query(value = "SELECT u.user_name, u.user_email, u.user_phone, u.user_password, u.user_role, m.*, u2.user_name AS author_name, u2.user_email AS author_email, u2.user_phone AS author_phone, u2.user_password AS author_password, u2.user_role AS author_role " +
	        "FROM Meetings m " +
	        "LEFT JOIN User u ON JSON_CONTAINS(m.meeting_attendee, CAST(u.user_id AS JSON)) " +
	        "JOIN User u2 ON m.meeting_organizer = u2.user_id",
	        nativeQuery = true)
	List<Map<String, Object>> getMeetingDetailsWithUserDetails();
}
