package com.sampreeth.aiinterview.service;


import com.sampreeth.aiinterview.model.Interview;
import com.sampreeth.aiinterview.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InterviewService {

    @Autowired
    private InterviewRepository interviewRepository;

    public Interview createInterview(Interview interview){
        return interviewRepository.save(interview);
    }

    public List<Interview> getAllInterviews(){
        return interviewRepository.findAll();
    }

    public Optional<Interview> getInterviewById(Long id){
        return interviewRepository.findById(id);
    }

    public Interview updateInterview(Long id, Interview updatedInterview){
        return interviewRepository.findById(id)
                .map(interview -> {
                    interview.setCandidate(updatedInterview.getCandidate());
                    interview.setInterviewer(updatedInterview.getInterviewer());
                    interview.setDate(updatedInterview.getDate());
                    interview.setStatus(updatedInterview.getStatus());
                    return interviewRepository.save(interview);
                })
                .orElse(null);
    }

    public void deleteInterview(Long id){
        interviewRepository.deleteById(id);
    }
}
