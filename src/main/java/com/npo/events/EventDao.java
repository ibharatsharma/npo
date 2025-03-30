package com.npo.events;

import com.npo.domain.member.domain.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface EventDao extends JpaRepository<Event, Long>, QueryByExampleExecutor<Event> {
}
