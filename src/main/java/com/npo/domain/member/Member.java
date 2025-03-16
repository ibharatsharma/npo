package com.npo.domain.member;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "members")
public record Member(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        Long id,
        String firstName,
        String lastname,
        LocalDate dob,
        String gender,
        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "address_id", referencedColumnName = "id")
        Address address
) {
}
