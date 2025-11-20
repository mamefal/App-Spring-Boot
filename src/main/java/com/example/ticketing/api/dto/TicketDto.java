package com.example.ticketing.api.dto;

import com.example.ticketing.domain.Ticket;
import lombok.Builder;
import lombok.Data;

@Data
public class TicketDto {

    private Long id;
    private String title;
    private String description;
    private String priority;
    private String status;
    private String requester;
    private String assignee;

    public static TicketDto from(Ticket t) {
        TicketDto dto = new TicketDto();
        dto.id = t.getId();
        dto.title = t.getTitle();
        dto.description = t.getDescription();
        dto.priority = t.getPriority().name();
        dto.status = t.getStatus().name();
        dto.requester = t.getRequester() != null ? t.getRequester().getEmail() : null;
        dto.assignee = t.getAssignee() != null ? t.getAssignee().getEmail() : null;
        return dto;
    }
}
