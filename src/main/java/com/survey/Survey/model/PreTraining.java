package com.survey.Survey.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PRE_TRAINING")
public class PreTraining {
	@Id
    @GeneratedValue(generator = "pre_training_generator")
    @SequenceGenerator(
            name = "pre_training_generator",
            sequenceName = "pre_training_generator",
            initialValue = 1
    )
	private Long id;
	@Column(unique = true)
	private String email;
	@Column(length = 1000)
	private String attend;
	@Column(length = 1000)
	private String attendReason;
	@Column(length = 1000)
	private String eventReason;
	@Column(length = 1000)
	private String topic;
	public String getAttend() {
		return attend;
	}
	public String getAttendReason() {
		return attendReason;
	}
	public String getEmail() {
		return email;
	}
	public String getEventReason() {
		return eventReason;
	}
	public Long getId() {
		return id;
	}
	public String getTopic() {
		return topic;
	}
	public void setAttend(String attend) {
		this.attend = attend;
	}
	public void setAttendReason(String attendReason) {
		this.attendReason = attendReason;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setEventReason(String eventReason) {
		this.eventReason = eventReason;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
}
