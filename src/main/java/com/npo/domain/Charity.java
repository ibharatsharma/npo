package com.npo.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "charity")
public class Charity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;                // Name of the charity
    private String registrationNumber;  // Unique identifier for legal registration
    private String purpose;             // The charitable purpose or mission
    private String address;             // Physical address of the charity
    private String contactInfo;         // Phone number or email for communication
    private boolean isActive;
    @OneToMany(mappedBy = "charity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Event> events;
}
