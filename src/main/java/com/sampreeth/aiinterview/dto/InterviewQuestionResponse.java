package com.sampreeth.aiinterview.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InterviewQuestionResponse {
    private Long id;
    private String questionText;
    private String category;
    private String difficulty;
    private String createdBy;
    private String createdAt;
}
