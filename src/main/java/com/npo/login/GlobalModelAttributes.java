package com.npo.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@Slf4j
@ControllerAdvice
public class GlobalModelAttributes {

    @ModelAttribute("currentUsername")
    public String getCurrentUsername(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated() && !"anonymousUser".equals(auth.getPrincipal())) {
            String currentUsername = ((UserDetails) auth.getPrincipal()).getUsername();
            log.info("currentUsername={}", currentUsername);
            model.addAttribute("currentUsername", currentUsername);
            return currentUsername;
        }
        return null;
    }

    @ModelAttribute("authorities")
    public Object getAuthorities(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated()) {
            return auth.getAuthorities(); // Collection<? extends GrantedAuthority>
        }
        return null;
    }
}
