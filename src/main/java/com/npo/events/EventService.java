package com.npo.events;

import com.npo.domain.member.domain.event.Event;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public void updateEvent(Event event){

    }

    public void deleteEventById(Long eventId){

    }

    public void deleteAllEvents(){

    }

    public void addMemberToEvent(Long eventId, Long memberId){

    }

    public void removeMemberFromEvent(Long eventId, Long memberId){

    }

    public boolean isEventFull(Long eventId){
        return false;
    }
}
