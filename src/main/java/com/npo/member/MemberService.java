package com.npo.member;

import com.npo.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberDao memberDao;

    public Member registerMember(MemberDto memberDto) {
        var member = convert(memberDto);
        return memberDao.save(member);
    }

    private Member convert(MemberDto memberDto) {
        return new Member(null,
                memberDto.firstName(),
                memberDto.lastName(),
                memberDto.dob(),
                memberDto.gender(),
                null);

    }


}
