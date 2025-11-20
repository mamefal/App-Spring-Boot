package com.example.ticketing.api.dto;

import com.example.ticketing.domain.Priority;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TicketCreateDto {

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    private Priority priority = Priority.MEDIUM;

    @NotBlank
    @Email
    private String requesterEmail;

    private Long assigneeId;
}
