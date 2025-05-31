package com.npo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.*;
import jakarta.persistence.Id;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "charity_event")
@IdClass(CharityEventId.class)
public class CharityEvent {
    @Id
    private Long charityId;
    @Id
    private Long eventId;
}
