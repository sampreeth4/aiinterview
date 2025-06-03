package com.sampreeth.aiinterview.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InterviewQuestionRequest {
    private String questionText;
    private String category;
    private String difficulty;
}
