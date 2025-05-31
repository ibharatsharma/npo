package com.npo.charity;

import com.npo.domain.Charity;
import com.npo.login.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class CharityService {

    private final CharityDao charityDao;
    private final CustomUserDetailsService customUserDetailsService;
    private final UserRepository userRepository;

    @Transactional
    public Charity registerCharity(final CharityDto charity){
        // todo: validation to check if email is already registered.
        Authority authority = new Authority(UserRole.ADMIN.getId(), UserRole.ADMIN.name());
        User user = new User(charity.getEmail(), charity.getPassword(), Set.of(authority));
        customUserDetailsService.saveUserDetails(user);
        Charity registeredCharity = charityDao.save(dtoToCharity(charity));
        log.info("Charity {} registered with id {}", registeredCharity.getName(), registeredCharity.getId());

        return registeredCharity;
    }

    public Optional<Charity> findCharity(long charityId){
        return charityDao.findById(charityId);
    }

    public List<Charity> findCharities(String name){
        Charity exampleCharity = new Charity();
        exampleCharity.setName(name);
        Example<Charity> example = Example.of(exampleCharity);
        return charityDao.findAll(example);
    }

    public List<Charity> finalAllCharities(){
        return charityDao.findAll();
    }

    private Charity dtoToCharity(CharityDto dto){
        Charity charity = new Charity();
        charity.setName(dto.getName());
        charity.setRegistrationNumber(dto.getRegistrationNumber());
        charity.setPurpose(dto.getPurpose());
        charity.setAddress(dto.getAddress());
        charity.setContactInfo(dto.getContactInfo());
        charity.setActive(dto.isActive());
        return charity;
    }


}
