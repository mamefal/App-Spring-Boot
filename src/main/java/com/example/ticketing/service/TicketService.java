package com.example.ticketing.service;

import com.example.ticketing.domain.*;
import com.example.ticketing.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TicketService {

    private final TicketRepo ticketRepo;
    private final UserRepo userRepo;
    private final CategoryRepo categoryRepo;
    private final GroupRepo groupRepo;


    public List<Ticket> findAll() {
        return ticketRepo.findAll();
    }

    @Transactional
    public Ticket create(
            String title,
            String description,
            Priority priority,
            String requesterEmail,
            Long assigneeId,
            Long groupId
    ) {
        // requester
        User requester = userRepo.findByEmail(requesterEmail);
        if (requester == null) {
            requester = new User();
            requester.setEmail(requesterEmail);
            requester.setFullName(requesterEmail);
            userRepo.save(requester);
        }

        Ticket t = new Ticket();
        t.setTitle(title);
        t.setDescription(description);
        t.setPriority(priority != null ? priority : Priority.MEDIUM);
        t.setStatus(Status.NEW);
        t.setRequester(requester);
        t.setCreatedAt(Instant.now());
        t.setUpdatedAt(Instant.now());

        if (assigneeId != null) {
            userRepo.findById(assigneeId).ifPresent(t::setAssignee);
        }

        return ticketRepo.save(t);
    }
}
