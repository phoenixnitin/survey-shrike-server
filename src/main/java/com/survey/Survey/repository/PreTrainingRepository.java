package com.survey.Survey.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.survey.Survey.model.PreTraining;

@Repository
public interface PreTrainingRepository extends JpaRepository<PreTraining, Long> {
	List<PreTraining> findByEmail(String email);
}
