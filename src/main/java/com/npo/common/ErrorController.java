package com.npo.common;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping("/error")
    public String handleError(Model model){
        return "errors/notFound.jte";
    }
}
