package com.example.ticketing.domain;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.Instant;
@Entity @Getter @Setter @NoArgsConstructor

public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

    @ManyToOne(optional=false) private Ticket ticket;

    @ManyToOne(optional=false) private User author;

    @NotBlank @Column(nullable=false, length=2000) private String body;

    @Column(nullable=false) private Instant createdAt = Instant.now();
}
