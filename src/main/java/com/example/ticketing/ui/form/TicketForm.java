package com.example.ticketing.ui.form;

import com.example.ticketing.domain.Priority;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TicketForm {

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    private Priority priority = Priority.MEDIUM;

    @NotBlank @Email
    private String requesterEmail;

    private Long assigneeId;
}
