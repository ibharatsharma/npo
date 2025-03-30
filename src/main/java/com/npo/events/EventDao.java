package com.npo.events;

import com.npo.domain.member.domain.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventDao extends JpaRepository<Event, Long> {
}
