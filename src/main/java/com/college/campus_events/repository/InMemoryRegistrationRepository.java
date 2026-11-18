package com.college.campus_events.repository;

import com.college.campus_events.model.Registration;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryRegistrationRepository
        implements RegistrationRepository {

    private final Map<Long, Registration> registrations =
            new ConcurrentHashMap<>();

    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Registration save(Registration registration) {

        if (registration.getId() == null) {
            registration.setId(idGenerator.getAndIncrement());
        }

        registrations.put(registration.getId(), registration);

        return registration;
    }

    @Override
    public List<Registration> findAll() {

        return new ArrayList<>(registrations.values());
    }

    @Override
    public Optional<Registration> findById(Long id) {

        return Optional.ofNullable(registrations.get(id));
    }

    @Override
    public void deleteById(Long id) {

        registrations.remove(id);
    }
}