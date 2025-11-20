package com.example.ticketing.api.controller;

import com.example.ticketing.api.dto.*;
import com.example.ticketing.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketApiController {

    private final TicketService ticketService;

    @PostMapping
    public TicketDto create(@RequestBody TicketCreateDto dto) {
        var t = ticketService.create(
                dto.getTitle(),
                dto.getDescription(),
                dto.getPriority(),
                dto.getRequesterEmail(),
                dto.getAssigneeId(),
                null    // pas encore de groupId dans l’API
        );

        return TicketDto.from(t);
    }
}
