package com.npo.domain.member;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "addresses")
public class Address{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String line1;
        private String line2;
        private String line3;
        private String postCode;
        private String city;
        private String country;

}
