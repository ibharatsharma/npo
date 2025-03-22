package com.npo.member;

import java.time.LocalDate;

public record MemberDto(
        String firstName,
        String lastName,
        LocalDate dob,
        String gender
) {
}
