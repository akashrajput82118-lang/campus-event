package com.college.campus_events.repository;

import com.college.campus_events.model.Registration;

import java.util.List;
import java.util.Optional;

public interface RegistrationRepository {

    Registration save(Registration registration);

    List<Registration> findAll();

    Optional<Registration> findById(Long id);

    void deleteById(Long id);
}