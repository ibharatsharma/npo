package com.npo.events;

import com.npo.member.MemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/events")
public class EventController {

    @GetMapping("/new")
    public String showEventForm(final Model model) {
        var event = new EventDto();
        model.addAttribute("e", event);
        return "newEvent";
    }

    @PostMapping
    public String processEventForm(@Validated MemberDto m, final Model model) {
        // persist into database.
        model.addAttribute("m", new MemberDto(null,null,null,null));
        model.addAttribute("message", "Registration Successful");

        log.info("Member registered: {}", m);
        return "memberRegistration";
    }

}
