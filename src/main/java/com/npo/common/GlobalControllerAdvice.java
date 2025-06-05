package com.npo.common;

import com.npo.domain.WebUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Collections;
import java.util.List;

@Slf4j
@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute("user")
    public WebUser addUserAndRolesToModel(Authentication authentication) {
        if(authentication != null) {
            String currentUsername = ((UserDetails) authentication.getPrincipal()).getUsername();
            List<String> roles = authentication.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .toList();
            return new WebUser(currentUsername, roles);
        }else {
            return new WebUser("NONE",Collections.emptyList());
        }
    }

    @ModelAttribute("username")
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

}
