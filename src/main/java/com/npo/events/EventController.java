package com.npo.events;

import com.npo.domain.Event;
import com.npo.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/charities/{charityId}/events")
public class EventController {

    private final EventService eventService;

    @GetMapping
    public String getAllEvents(@PathVariable Long charityId, Model model) {
        List<Event> events = eventService.findByCharityId(charityId);
        model.addAttribute("eventCount", events.size());
        model.addAttribute("events", events);
        return "event/listEvents";
    }

    @GetMapping("/{eventId}")
    public String getEvent(@PathVariable Long charityId, @PathVariable Long eventId, Model model) {
        Event event = eventService.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
        model.addAttribute("event", event);
        return "event/eventDetails";
    }

    @GetMapping("/new")
    public String showEventForm(@PathVariable Long charityId, final Model model) {
        var event = new EventDto();
        model.addAttribute("e", event);
        model.addAttribute("charityId", charityId);
        return "newEvent";
    }

    @PostMapping
    public String processEventForm(@PathVariable Long charityId, @Validated EventDto eventDto, final Model model) {
        // persist into database.
        log.info("eventDto: {}", eventDto);

        Event savedEvent = eventService.createEvent(charityId, mapToEvent(eventDto));

        if(savedEvent.getId() != null){
            model.addAttribute("e", eventDto);
            model.addAttribute("message", "Event Created!");
        }else{
            model.addAttribute("e", eventDto);
        }
        return "redirect:/charities/" + charityId + "/events";

    }

    /**
     * Update event
     * @param charityId
     * @param eventId
     * @param event
     * @return
     */
    @PutMapping("/{eventId}")
    public String updateEvent(@PathVariable Long charityId, @PathVariable Long eventId, @ModelAttribute Event event) {
        eventService.updateEvent(charityId, eventId, event);
        return "redirect:/charities/" + charityId + "/events/" + eventId;
    }


    @DeleteMapping("/{eventId}")
    public String deleteEvent(@PathVariable Long charityId, @PathVariable Long eventId) {
        eventService.deleteEvent(eventId);
        return "redirect:/charities/" + charityId + "/events";
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
