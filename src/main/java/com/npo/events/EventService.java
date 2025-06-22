package com.npo.events;

import com.npo.charity.CharityService;
import com.npo.domain.Charity;
import com.npo.domain.Event;
import com.npo.domain.EventRecurrence;
import com.npo.domain.EventRecurrenceType;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventService {

    private final EventDao eventDao;
    private final CharityService charityService;

    @Transactional
    public Event createEvent(Long charityId, final EventDto eventDto){

        Event event = mapToEvent(eventDto);

        Optional<Charity> charityOptional = charityService.findCharity(charityId);
        return charityOptional.map(charity -> {
                event.setCharity(charity);
                populateEventRecurrences(eventDto, event);
                log.info("Event has {} recurrences", event.getRecurrences().size());
                return eventDao.save(event);
                }).orElseThrow();
    }

    // todo: a method should never modify it's parameters
    private Event populateEventRecurrences(final EventDto eventDto, final Event event){
        if(eventDto.getIsRecurring()){
           if(eventDto.getRecurrenceType().equals(EventRecurrenceType.DAILY)){
               event.setRecurrences(getDailyRecurrences(event));
           }
        }
        return event;
    }

    private List<EventRecurrence> getDailyRecurrences(final Event event){
        return event.getStartDate().toLocalDate().datesUntil(event.getEndDate().toLocalDate())
                .map(localDate -> {
                    EventRecurrence recurrence = new EventRecurrence();
                    recurrence.setNote(event.getNote());
                    recurrence.setLocation(event.getLocation());
                    recurrence.setStartDate(LocalDateTime.of(localDate, event.getStartDate().toLocalTime()));
                    recurrence.setEndDate(LocalDateTime.of(localDate, event.getEndDate().toLocalTime()));
                    recurrence.setEvent(event);
                    return recurrence;
                }).toList();
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


    public Optional<Event> getEventById(Long eventId){
        return eventDao.findById(eventId);
    }

    public void findAllFutureEvents(Event event){
        Example<Event> example = Example.of(event);
        eventDao.findAll(example);
    }

    @Transactional
    public void updateEvent(Long charityId, Long eventId, Event event){

    }

    public boolean isEventFull(Long eventId){
        return false;
    }

    public List<Event> findByCharityId(Long charityId) {
        return charityService.findCharity(charityId).map(Charity::getEvents)
                .orElse(Collections.emptyList());
        //return eventDao.findfindByCharityIdOrderByStartDateAsc(charityId);
    }

    public Optional<Event> findById(Long eventId) {
        return eventDao.findById(eventId);
    }

    @Transactional
    public void deleteEvent(Long eventId) {
        log.info("Deleting event with eventId={}", eventId);
        eventDao.deleteById(eventId);
    }
}
