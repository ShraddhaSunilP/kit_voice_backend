package springboot.kitvoicebackend.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Meetings {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String meeting_url;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime meeting_time;
	
	@Column(columnDefinition = "json")
	private String meeting_attendee;
	
	private int meeting_organizer;

	public Meetings() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Meetings(int id, String meeting_url, LocalDateTime meeting_time, String meeting_attendee,
			int meeting_organizer) {
		super();
		this.id = id;
		this.meeting_url = meeting_url;
		this.meeting_time = meeting_time;
		this.meeting_attendee = meeting_attendee;
		this.meeting_organizer = meeting_organizer;
	}

	@Override
	public String toString() {
		return "Meetings [id=" + id + ", meeting_url=" + meeting_url + ", meeting_time=" + meeting_time
				+ ", meeting_attendee=" + meeting_attendee + ", meeting_organizer=" + meeting_organizer + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMeeting_url() {
		return meeting_url;
	}

	public void setMeeting_url(String meeting_url) {
		this.meeting_url = meeting_url;
	}

	public LocalDateTime getMeeting_time() {
		return meeting_time;
	}

	public void setMeeting_time(LocalDateTime meeting_time) {
		this.meeting_time = meeting_time;
	}

	public String getMeeting_attendee() {
		return meeting_attendee;
	}

	public void setMeeting_attendee(String meeting_attendee) {
		this.meeting_attendee = meeting_attendee;
	}

	public int getMeeting_organizer() {
		return meeting_organizer;
	}

	public void setMeeting_organizer(int meeting_organizer) {
		this.meeting_organizer = meeting_organizer;
	}

}
