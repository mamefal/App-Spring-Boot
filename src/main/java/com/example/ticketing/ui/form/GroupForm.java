package com.example.ticketing.ui.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class GroupForm {

    @NotBlank
    private String name;

    private String description;
}
