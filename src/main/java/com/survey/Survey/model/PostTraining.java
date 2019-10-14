package com.survey.Survey.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "POST_TRAINING")
public class PostTraining {
	@Id
    @GeneratedValue(generator = "post_training_generator")
    @SequenceGenerator(
            name = "post_training_generator",
            sequenceName = "post_training_generator",
            initialValue = 1,
            allocationSize=1
    )
	private Long id;
	@Column(unique = true)
	private String email;
	private String name;
	@Column(length = 1000)
	private String training;
	@Column(length = 1000)
	private String satisfiedLevel;
	@Column(length = 1000)
	private String quality;
	@Column(length = 1000)
	private String attendBefore;
	@Column(length = 1000)
	private String attendReasonPost;
	@Column(length = 1000)
	private String recommend;
	@Column(length = 1000)
	private String comments;
	public String getAttendBefore() {
		return attendBefore;
	}
	public String getAttendReasonPost() {
		return attendReasonPost;
	}
	public String getComments() {
		return comments;
	}
	public String getEmail() {
		return email;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getQuality() {
		return quality;
	}
	public String getRecommend() {
		return recommend;
	}
	public String getSatisfiedLevel() {
		return satisfiedLevel;
	}
	public String getTraining() {
		return training;
	}
	public void setAttendBefore(String attendBefore) {
		this.attendBefore = attendBefore;
	}
	public void setAttendReasonPost(String attendReasonPost) {
		this.attendReasonPost = attendReasonPost;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	public void setSatisfiedLevel(String satisfiedLevel) {
		this.satisfiedLevel = satisfiedLevel;
	}
	public void setTraining(String training) {
		this.training = training;
	}
}
