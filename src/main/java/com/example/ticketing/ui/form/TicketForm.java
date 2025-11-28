package com.example.ticketing.ui.form;

import com.example.ticketing.domain.Priority;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class TicketForm {

    private String title;

    private String description;

    private String requesterEmail;

    private Priority priority;

    private Long requesterId;

    private Long assigneeId;

    private String author;

    private Long categoryId;

    private Long groupId;

}
