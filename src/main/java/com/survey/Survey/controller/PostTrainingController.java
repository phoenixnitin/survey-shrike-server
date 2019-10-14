package com.survey.Survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.survey.Survey.model.PostTraining;
import com.survey.Survey.repository.PostTrainingRepository;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/posttraining")
public class PostTrainingController {
	@Autowired
    private PostTrainingRepository postTrainingRepository;
	
	@GetMapping("/findAll")
	public List<PostTraining> getAll() {
		return postTrainingRepository.findAll();
	}
	@PostMapping("/findByEmail")
	public List<PostTraining> findByEmail(@RequestBody String email) {
		return postTrainingRepository.findByEmail(email);
	}
	@PostMapping("/create")
	public PostTraining create(@RequestBody PostTraining postTraining) {
		return postTrainingRepository.save(postTraining);
	}
	@PutMapping("/update/{postTrainingId}")
    public ResponseEntity<?> updatePostTraining(@PathVariable Long postTrainingId, @RequestBody PostTraining postTraining) {
		if(!postTrainingRepository.existsById(postTrainingId)) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
        return postTrainingRepository.findById(postTrainingId)
                .map(posttrain -> {
                	posttrain.setEmail(postTraining.getEmail());
                	posttrain.setAttendBefore(postTraining.getAttendBefore());
                	posttrain.setAttendReasonPost(postTraining.getAttendReasonPost());
                	posttrain.setComments(postTraining.getComments());
                	posttrain.setName(postTraining.getName());
                	posttrain.setQuality(postTraining.getQuality());
                	posttrain.setRecommend(postTraining.getRecommend());
                	posttrain.setSatisfiedLevel(postTraining.getSatisfiedLevel());
                	posttrain.setTraining(postTraining.getTraining());
                	postTrainingRepository.save(posttrain);
                    return ResponseEntity.ok().build();
                }).orElse(new ResponseEntity<Object>(HttpStatus.BAD_GATEWAY));
    }
	
	@DeleteMapping("/delete/{postTrainingId}")
    public ResponseEntity<?> deletePostTraining(@PathVariable Long postTrainingId) {
		if(!postTrainingRepository.existsById(postTrainingId)) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
        return postTrainingRepository.findById(postTrainingId)
                .map(posttraining -> {
                    postTrainingRepository.deleteById(postTrainingId);
                    return ResponseEntity.ok().build();
                }).orElse(new ResponseEntity<Object>(HttpStatus.BAD_GATEWAY));
    }
}
