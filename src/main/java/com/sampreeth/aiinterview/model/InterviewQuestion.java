package com.sampreeth.aiinterview.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InterviewQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String questionText;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String difficulty;

    private String createdBy;

    private LocalDateTime createdAt;
}
