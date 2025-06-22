package com.npo.events;

import com.npo.domain.EventRecurrenceType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {

    private String name;
    private String description;
    // recurrence
    private Boolean isRecurring;
    private EventRecurrenceType recurrenceType;

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String location;
    private String organizer;
    private Boolean isPrivate;
    private String category;

}
