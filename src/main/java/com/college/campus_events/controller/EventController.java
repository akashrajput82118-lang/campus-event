package com.college.campus_events.controller;


import com.college.campus_events.model.Event;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EventController {

    private List<Event> events = new ArrayList<>();

    public EventController() {
        events.add(new Event(1, "Tech Fest", "College Auditorium",
                LocalDate.of(2026, 12, 10), 500));

        events.add(new Event(2, "Coding Competition", "Lab 1",
                LocalDate.of(2026, 12, 15), 100));

        events.add(new Event(3, "Sports Day", "College Ground",
                LocalDate.of(2026, 12, 20), 300));
    }

    @GetMapping("/api/events/status")
    public String status(){
        return "Campus Events API ready.";
    }

    @GetMapping("/api/events/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable int id){

        for (Event event : events){
            if(event.getId() == id){
                return ResponseEntity.ok(event);
            }
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/events")
    public ResponseEntity<Event> createEvent(@RequestBody Event event){
        events.add(event);

        return ResponseEntity.status(HttpStatus.CREATED).body(event);
    }

    @GetMapping("/api/events/search")
    public List<Event> searchEvents(@RequestParam String venue){
        return events.stream().filter(event -> event.getVenue().equalsIgnoreCase(venue)).collect(Collectors.toList());
    }

    @PutMapping("/api/events/{id}/capacity")
    public ResponseEntity<Event> updateEventCapacity(@PathVariable int id, @RequestParam int capacity){
        for (Event event : events){
            if (event.getId() == id){
                event.setCapacity(capacity);
                return ResponseEntity.ok(event);
            }
        }
        return ResponseEntity.notFound().build();
    }
}
