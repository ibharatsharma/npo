package com.npo.member;

import java.time.LocalDate;

public record MemberDto(
        String firstName,
        String lastname,
        LocalDate dob,
        String gender
) {
}
