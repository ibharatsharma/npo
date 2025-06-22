package com.npo.domain;

import jakarta.persistence.*;
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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String location;
    @Column(length = 500)
    private String note;
    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;
}
