package com.npo.charity;

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
@RequestMapping(path = "/charities")
public class CharityController {

    private final CharityService charityService;

    /**
     * Displays a list of all Charities
     */
    @GetMapping
    public String showAllCharities(Model model){
       model.addAttribute("charities", charityService.finalAllCharities());
       return "showCharities";
    }

    @GetMapping("/registration")
    public String showRegistrationFrom(Model model){
        model.addAttribute("charity", new CharityDto());
        return "charityRegistration";
    }

    @PostMapping("/registration")
    public String processRegistrationFrom(@Validated CharityDto charity, Model model){
        log.info("charity - {}", charity);
        model.addAttribute("charity", new CharityDto());
        return "charityRegistration";
    }

}
