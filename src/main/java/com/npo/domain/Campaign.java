package com.npo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "campaign")
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    @Column(length = 500)
    private String description;
    private Boolean isClosed;

    // Bidirectional OneToMany
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "campaign_id")
    private List<Event> events = new ArrayList<>();

    // Convenience method (optional but helpful)
    public void addEvent(Event event) {
        events.add(event);
        event.setCampaign(this);
    }

    public void removeEvent(Event event) {
        events.remove(event);
        event.setCampaign(null);
    }


}
