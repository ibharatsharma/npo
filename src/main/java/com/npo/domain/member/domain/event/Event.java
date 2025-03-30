package com.npo.domain.member.domain.event;

import com.npo.domain.member.Participant;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
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
    @ManyToMany(mappedBy = "events")
    private List<Participant> participants;
    private Boolean isPrivate;
    private String category;

}
