package com.npo.events;

import com.npo.charity.CharityService;
import com.npo.domain.Charity;
import com.npo.domain.Event;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

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
    public Event createEvent(Long charityId, final Event event){
        Optional<Charity> charityOptional = charityService.findCharity(charityId);
        return charityOptional.map(charity -> {
                //event.setCharity(charity);
                return eventDao.save(event);
                }).orElseThrow();
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
