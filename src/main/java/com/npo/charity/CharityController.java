package com.npo.charity;

import com.npo.domain.Charity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
    public String processRegistrationFrom(@Valid CharityDto charity, Model model){
        log.info("charity - {}", charity);
        Charity registeredCharity = charityService.registerCharity(charity);
        model.addAttribute("charity", new CharityDto());
        model.addAttribute("message", registeredCharity.getName() + " charity registered successfully!");
        return "charityRegistration";
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleValidationException(MethodArgumentNotValidException exception, Model model){
        CharityDto charity = (CharityDto) exception.getBindingResult().getTarget();
        model.addAttribute("charity", charity);
        model.addAttribute("error", "Please fill out required fields.");
        model.addAttribute("bindingResult", exception.getBindingResult());
        return "charityRegistration";
    }

}
