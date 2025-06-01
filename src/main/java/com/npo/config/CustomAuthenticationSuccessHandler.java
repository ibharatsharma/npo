package com.npo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Slf4j
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException, ServletException {

        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        log.info("roles: {}", roles);

        if (roles.contains("SUPER_ADMIN")) {
            response.sendRedirect("/admin/dashboard");
        } else if (roles.contains("ADMIN")) {
            response.sendRedirect("/charities");
        } else if (roles.contains("ROLE_WORKER")) {
        response.sendRedirect("/dashboard");
        } else {
            response.sendRedirect("/");
        }
    }
}
