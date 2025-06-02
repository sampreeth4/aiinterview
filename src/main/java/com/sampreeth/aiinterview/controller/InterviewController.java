package com.sampreeth.aiinterview.controller;

import com.sampreeth.aiinterview.model.Interview;
import com.sampreeth.aiinterview.service.InterviewService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interviews")
@CrossOrigin
public class InterviewController {

    @Autowired
    private InterviewService interviewService;

    @PostMapping
    public Interview createInterview(@RequestBody Interview interview){
        return interviewService.createInterview(interview);
    }

    @GetMapping
    public List<Interview> getAllInterviews(){
        return interviewService.getAllInterviews();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Interview> getInterviewById(@PathVariable Long id){
        return interviewService.getInterviewById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Interview> updateInterview(@PathVariable Long id, @RequestBody Interview updatedInterview){
        Interview updated = interviewService.updateInterview(id, updatedInterview);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInterview(@PathVariable Long id){
        interviewService.deleteInterview(id);
        return ResponseEntity.noContent().build();
    }
}
