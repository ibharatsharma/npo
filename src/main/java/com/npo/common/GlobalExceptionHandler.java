package com.npo.common;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    //@ExceptionHandler(NoResourceFoundException.class)
    public String handleResourceNotFoundException(NoResourceFoundException exception, Model model){
        return "errors/notFound.jte";
    }
}
