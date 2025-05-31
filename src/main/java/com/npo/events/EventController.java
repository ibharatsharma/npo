package com.npo.events;

import com.npo.domain.Event;
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

    private final EventService eventService;

    @GetMapping("/new")
    public String showEventForm(final Model model) {
        var event = new EventDto();
        model.addAttribute("e", event);
        return "newEvent";
    }

    @PostMapping
    public String processEventForm(@Validated EventDto eventDto, final Model model) {
        // persist into database.
        log.info("eventDto: {}", eventDto);

        Event savedEvent = eventService.createEvent(mapToEvent(eventDto));

        if(savedEvent.getId() != null){
            model.addAttribute("e", eventDto);
            model.addAttribute("message", "Event Created!");
        }else{
            model.addAttribute("e", eventDto);
        }
        return "newEvent";

    }

    private Event mapToEvent(EventDto dto){
        return Event.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .location(dto.getLocation())
                .organizer(dto.getOrganizer())
                .isPrivate(dto.getIsPrivate())
                .category(dto.getCategory())
                .build();
    }

}
