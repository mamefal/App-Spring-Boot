package com.example.ticketing.ui.controller;

import com.example.ticketing.domain.Group;
import com.example.ticketing.repository.GroupRepo;
import com.example.ticketing.ui.form.GroupForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/groups")
@RequiredArgsConstructor
public class GroupPageController {

    private final GroupRepo groupRepo;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("groups", groupRepo.findAll());
        return "groups/list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("groupForm", new GroupForm());
        return "groups/new";
    }

    @PostMapping
    public String create(@ModelAttribute("groupForm") @Valid GroupForm form,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "groups/new";
        }
        Group g = new Group();
        g.setName(form.getName());
        g.setDescription(form.getDescription());
        groupRepo.save(g);
        return "redirect:/groups";
    }

}
