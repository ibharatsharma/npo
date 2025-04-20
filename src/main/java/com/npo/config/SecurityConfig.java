package com.npo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        //.requestMatchers("/").permitAll() // home page access for everyone
                        .requestMatchers("/ott/sent").permitAll() // ott sent page
                        .requestMatchers("/login/ott").permitAll()
                        .requestMatchers("/members/registration").permitAll()
                        .requestMatchers("/admin/**").hasAnyRole("ADMIN")
                        .anyRequest().authenticated()
                )
                /*.formLogin(login -> login
                        .loginPage("/login")
                        .successHandler(new CustomAuthenticationSuccessHandler())
                        .permitAll()
                )*/
                .formLogin(Customizer.withDefaults())
                .oneTimeTokenLogin(Customizer.withDefaults())
                .build();
    }

    /*
    @Bean
    InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        var user = User.withUsername("user")
                .password("{noop}password")
                .authorities()
                .build();
        return new InMemoryUserDetailsManager(user);
    }*/

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
        //return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


}
