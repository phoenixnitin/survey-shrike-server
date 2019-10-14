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

import com.survey.Survey.model.PreTraining;
import com.survey.Survey.repository.PreTrainingRepository;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/pretraining")
public class PreTrainingController {
	@Autowired
    private PreTrainingRepository preTrainingRepository;
	
	@GetMapping("/findAll")
	public List<PreTraining> getAll() {
		return preTrainingRepository.findAll();
	}
	@PostMapping("/findByEmail")
	public List<PreTraining> findByEmail(@RequestBody String email) {
		return preTrainingRepository.findByEmail(email);
	}
	@PostMapping("/create")
	public PreTraining create(@RequestBody PreTraining preTraining) {
		return preTrainingRepository.save(preTraining);
	}
	@PutMapping("/update/{preTrainingId}")
    public ResponseEntity<?> updatePreTraining(@PathVariable Long preTrainingId, @RequestBody PreTraining preTraining) {
		if(!preTrainingRepository.existsById(preTrainingId)) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
        return preTrainingRepository.findById(preTrainingId)
                .map(pretrain -> {
                	pretrain.setEmail(preTraining.getEmail());
                	pretrain.setAttend(preTraining.getAttend());
                	pretrain.setAttendReason(preTraining.getAttendReason());
                	pretrain.setEventReason(preTraining.getEventReason());
                	pretrain.setTopic(preTraining.getTopic());
                    preTrainingRepository.save(pretrain);
                    return ResponseEntity.ok().build();
                }).orElse(new ResponseEntity<Object>(HttpStatus.BAD_GATEWAY));
    }
	
	@DeleteMapping("/delete/{preTrainingId}")
    public ResponseEntity<?> deletePreTraining(@PathVariable Long preTrainingId) {
		if(!preTrainingRepository.existsById(preTrainingId)) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
        return preTrainingRepository.findById(preTrainingId)
                .map(pretraining -> {
                    preTrainingRepository.deleteById(preTrainingId);
                    return ResponseEntity.ok().build();
                }).orElse(new ResponseEntity<Object>(HttpStatus.BAD_GATEWAY));
    }
}
