package com.npo.events;

import com.npo.domain.Event;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventDao eventDao;

    @Transactional
    public Event createEvent(Event event){
        return eventDao.save(event);
    }

    public Optional<Event> getEventById(Long eventId){
        return eventDao.findById(eventId);
    }

    public void findAllFutureEvents(Event event){
        Example<Event> example = Example.of(event);
        eventDao.findAll(example);
    }

    public void updateEvent(Long charityId, Long eventId, Event event){

    }

    public boolean isEventFull(Long eventId){
        return false;
    }

    public List<Event> findByCharityId(Long charityId) {
        return List.of();
    }

    public Optional<Event> findById(Long eventId) {
        return Optional.empty();
    }

    public void deleteEvent(Long eventId) {
        throw new RuntimeException("implementation pending");
    }
}
