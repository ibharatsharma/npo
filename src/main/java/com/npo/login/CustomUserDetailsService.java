package com.npo.login;

import com.npo.domain.NpoRoles;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));*/

        Optional<User> user = userRepository.findByUsername(username);
        if(user.isPresent()) {
            log.info("user: {}", user.get());
            return user.get();

        }
        else {
            var msg = "User not found with username: " + username;
            log.info("User not found, throwing exception. {}", msg);
            throw new UsernameNotFoundException(msg);
        }
    }

    public void saveUserDetails(Long charityId){

        Authority authority = new Authority();
        authority.setId(6L);
        authority.setName(NpoRoles.CHARITY_ADMIN.toString());

        User charity = new User();
        charity.setUsername("c" + charityId);
        charity.setPassword("pass");
        charity.setAuthorities(Set.of(authority));

        User persistedCharity = userRepository.save(charity);
        log.info("Charity User created for charityId={}", charityId);
    }
}