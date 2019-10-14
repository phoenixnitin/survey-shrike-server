package com.survey.Survey.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.survey.Survey.model.PostTraining;

@Repository
public interface PostTrainingRepository extends JpaRepository<PostTraining, Long> {
	List<PostTraining> findByEmail(String email);
}
