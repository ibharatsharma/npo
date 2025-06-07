package com.npo.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

//@Data
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(length = 500)
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String location;
    private String organizer;
    private Boolean isPrivate;
    private String category;
    //@ManyToOne
    //@JoinColumn(name = "charity_id", nullable = false)
    //private Charity charity;
    @Column(length = 500)
    private String note;
    //    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "event_id") // FK in event_reoccurrence table
    private List<EventRecurrence> recurrences;
}
