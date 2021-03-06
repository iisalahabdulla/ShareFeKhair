package com.example.sharefekhair.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor @Data @NoArgsConstructor
public class UpdateNoteDTO {
    @NotEmpty(message = "body is required")
    private String body;
}
