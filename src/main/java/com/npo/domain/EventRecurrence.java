package com.npo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "event_recurrence")
public class EventRecurrence {

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String location;
    @Column(length = 500)
    private String note;

}
