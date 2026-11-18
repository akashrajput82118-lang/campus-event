package com.college.campus_events.controller;

import com.college.campus_events.model.Participant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ParticipantController {

    @GetMapping("/participants/register")
    public String showForm(Model model) {

        model.addAttribute("participant", new Participant());

        return "participant-form";
    }

    @PostMapping("/participants/register")
    public String registerParticipant(
            @ModelAttribute Participant participant,
            Model model) {

        model.addAttribute("participant", participant);

        return "confirmation";
    }
}