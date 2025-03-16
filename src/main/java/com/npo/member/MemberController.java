package com.npo.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping(path = "/registration")
    public String showRegistrationform(final Model model) {
        var m = new MemberDto(null,null,null,null);
        model.addAttribute("member", m);

        return "memberRegistration";
    }

    @PostMapping(path = "/registration")
    public String processRegistrationform(@Validated MemberDto member, final Model model) {
        // persist into database.
        model.addAttribute("member", new MemberDto(null,null,null,null));
        model.addAttribute("message", "Registration Successful");

        memberService.registerMember(member);
        log.info("Member registered: {}", member);
        return "memberRegistration";
    }

}
