package com.sampreeth.aiinterview.repository;

import com.sampreeth.aiinterview.model.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Long>{
}
