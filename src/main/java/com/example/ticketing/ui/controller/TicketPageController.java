package com.example.ticketing.ui.controller;

import com.example.ticketing.domain.Priority;
import com.example.ticketing.repository.UserRepo;
import com.example.ticketing.service.TicketService;
import com.example.ticketing.ui.form.TicketForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tickets")
@RequiredArgsConstructor
public class TicketPageController {

    private final TicketService ticketService;
    private final UserRepo userRepo;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("tickets", ticketService.findAll());
        return "tickets/list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("ticketForm", new TicketForm());
        model.addAttribute("priorities", Priority.values());
        model.addAttribute("users", userRepo.findAll());
        return "tickets/new";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute("ticketForm") TicketForm form,
                         BindingResult bindingResult,
                         Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("priorities", Priority.values());
            model.addAttribute("users", userRepo.findAll());
            return "tickets/new";
        }

        ticketService.create(
                form.getTitle(),
                form.getDescription(),
                form.getPriority(),
                form.getRequesterEmail(),
                form.getAssigneeId(),
                null   // on branchera sur un vrai groupId plus tard
        );


        return "redirect:/tickets";
    }
}
