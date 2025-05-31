package com.sampreeth.aiinterview.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String candidateEmail;

    private String status;

    private LocalDateTime startedAt;

    private LocalDateTime completedAt;

    public Interview(){}

    public Interview(String candidateEmail, String status, LocalDateTime startedAt){
        this.candidateEmail = candidateEmail;
        this.status = status;
        this.startedAt = startedAt;
    }

    public Long getId(){
        return id;
    }

    public String getCandidateEmail(){
        return candidateEmail;
    }

    public void setCandidateEmail(String candidateEmail) {
        this.candidateEmail = candidateEmail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }
}
