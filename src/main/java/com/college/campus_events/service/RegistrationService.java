package com.college.campus_events.service;

import com.college.campus_events.model.Registration;
import com.college.campus_events.repository.RegistrationRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

    private final RegistrationRepository repository;

    public RegistrationService(RegistrationRepository repository) {
        this.repository = repository;
    }

    public Registration createRegistration(Registration registration) {

        registration.setId(null);

        return repository.save(registration);
    }

    public List<Registration> getAllRegistrations() {

        return repository.findAll();
    }

    public Registration getRegistrationById(Long id) {

        return repository.findById(id).orElse(null);
    }

    public Registration updateRegistration(
            Long id, Registration updatedRegistration) {

        Registration existing = repository.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        existing.setParticipantName(
                updatedRegistration.getParticipantName());

        existing.setEmail(
                updatedRegistration.getEmail());

        existing.setEventName(
                updatedRegistration.getEventName());

        return repository.save(existing);
    }

    public boolean deleteRegistration(Long id) {

        if (repository.findById(id).isEmpty()) {
            return false;
        }

        repository.deleteById(id);

        return true;
    }
}