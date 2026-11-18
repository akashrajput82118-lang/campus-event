package com.college.campus_events.controller;

import com.college.campus_events.model.Registration;
import com.college.campus_events.service.RegistrationService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registrations")
public class RegistrationController {

    private final RegistrationService service;

    public RegistrationController(RegistrationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Registration> createRegistration(
            @RequestBody Registration registration) {

        Registration saved = service.createRegistration(registration);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Registration>> getAllRegistrations() {

        return ResponseEntity.ok(service.getAllRegistrations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Registration> getRegistrationById(
            @PathVariable Long id) {

        Registration registration = service.getRegistrationById(id);

        if (registration == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(registration);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Registration> updateRegistration(
            @PathVariable Long id,
            @RequestBody Registration registration) {

        Registration updated = service.updateRegistration(id, registration);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegistration(
            @PathVariable Long id) {

        boolean deleted = service.deleteRegistration(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}