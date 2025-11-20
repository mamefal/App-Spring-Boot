package com.example.ticketing.repository;

import com.example.ticketing.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository

public interface TicketRepo extends JpaRepository<Ticket, Long>,
        JpaSpecificationExecutor<Ticket> {
}
