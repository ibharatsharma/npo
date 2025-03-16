package com.npo.domain.member;

import jakarta.persistence.*;

@Entity
@Table(name = "addresses")
public record Address(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        Long id,
        String line1,
        String line2,
        String line3,
        String postCode,
        String city,
        String country
) {
}
