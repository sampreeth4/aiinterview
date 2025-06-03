package com.sampreeth.aiinterview.repository;

import com.sampreeth.aiinterview.model.InterviewQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewQuestionRepository extends JpaRepository<InterviewQuestion, Long>{
}
