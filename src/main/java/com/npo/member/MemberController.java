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
    public String showRegistrationForm(final Model model) {
        var m = new MemberDto(null,null,null,null);
        model.addAttribute("m", m);

        return "memberRegistration";
    }

    @PostMapping(path = "/registration")
    public String processRegistrationForm(@Validated MemberDto m, final Model model) {
        // persist into database.
        model.addAttribute("m", new MemberDto(null,null,null,null));
        model.addAttribute("message", "Registration Successful");

        memberService.registerMember(m);
        log.info("Member registered: {}", m);
        return "memberRegistration";
    }

}
