package com.example.ticketing.service;

import com.example.ticketing.domain.Group;
import com.example.ticketing.domain.Priority;
import com.example.ticketing.domain.Ticket;
import com.example.ticketing.domain.User;
import com.example.ticketing.repository.GroupRepo;
import com.example.ticketing.repository.TicketRepo;
import com.example.ticketing.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepo ticketRepo;
    private final GroupRepo groupRepo;
    private final UserRepo userRepo;

    public TicketService(TicketRepo ticketRepo,
                         GroupRepo groupRepo,
                         UserRepo userRepo) {
        this.ticketRepo = ticketRepo;
        this.groupRepo = groupRepo;
        this.userRepo = userRepo;
    }

    public List<Ticket> findAll() {
        return ticketRepo.findAll();
    }

    public Ticket getById(Long id) {
        return ticketRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found: " + id));
    }

    public Ticket create(String title,
                         String description,
                         Priority priority,
                         String requesterEmail,
                         Long assigneeId,
                         Long groupId) {

        Ticket ticket = new Ticket();
        ticket.setTitle(title);
        ticket.setDescription(description);
        ticket.setPriority(
                priority != null ? priority : Priority.MEDIUM
        );

        // 🔹 requester (obligatoire)
        User requester = userRepo.findByEmail(requesterEmail);

        if (requester == null) {
            // On crée automatiquement un user si l'email n'existe pas
            requester = new User();
            requester.setEmail(requesterEmail);
            requester.setFullName(requesterEmail);

            requester = userRepo.save(requester);
        }

        ticket.setRequester(requester);


        // assignee (optionnel)
        if (assigneeId != null) {
            User assignee = userRepo.findById(assigneeId)
                    .orElseThrow(() -> new RuntimeException("Assignee not found: " + assigneeId));
            ticket.setAssignee(assignee);
        }

        // groupe (optionnel)
        if (groupId != null) {
            Group group = groupRepo.findById(groupId)
                    .orElseThrow(() -> new RuntimeException("Group not found: " + groupId));
            ticket.setGroup(group);
        }

        return ticketRepo.save(ticket);
    }
}
