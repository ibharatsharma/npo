package com.npo.events;

import com.npo.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface EventDao extends JpaRepository<Event, Long>, QueryByExampleExecutor<Event> {

    //List<Event> findByCharityId(Long charityId);

    //List<Event> findByCharityIdOrderByStartDateAsc(Long charityId);


}
