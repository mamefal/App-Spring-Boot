package com.example.ticketing.domain;

import jakarta.persistence.*;
import java.util.List;
import com.example.ticketing.domain.User;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    @OneToMany(mappedBy = "group")
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "group")
    private List<User> members;


}
