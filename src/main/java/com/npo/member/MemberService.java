package com.npo.member;

import com.npo.domain.member.Participant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberDao memberDao;

    public Participant registerParticipant(MemberDto memberDto) {
        var member = convert(memberDto);
        return memberDao.save(member);
    }

    private Participant convert(MemberDto memberDto) {
        return new Participant(null,
                memberDto.firstName(),
                memberDto.lastName(),
                memberDto.dob(),
                memberDto.gender(),
                null,
                null);

    }


}
