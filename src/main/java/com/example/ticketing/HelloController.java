package com.example.ticketing;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloController {
    @GetMapping("/api/health")
    public String health() { return "OK"; }
}
