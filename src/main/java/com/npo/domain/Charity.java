package com.npo.domain;

import jakarta.persistence.*;
import lombok.*;

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

}
