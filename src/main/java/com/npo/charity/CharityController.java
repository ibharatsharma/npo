package com.npo.charity;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
