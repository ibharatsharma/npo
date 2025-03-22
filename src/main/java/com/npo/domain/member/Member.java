package com.npo.domain.member;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "members")
public class Member{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String firstName;
        private String lastname;
        private LocalDate dob;
        private String gender;
        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "address_id", referencedColumnName = "id")
        private Address address;
}
