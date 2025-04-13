package com.npo.charity;

import com.npo.domain.Charity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CharityService {

    private final CharityDao chartiyDao;

    public Charity registerCharity(final CharityDto charity){
        Charity registeredCharity = chartiyDao.save(dtoToCharity(charity));
        log.info("Charity {} registered with id {}", registeredCharity.getName(), registeredCharity.getId());
        return registeredCharity;
    }

    public Optional<Charity> findCharity(long charityId){
        return chartiyDao.findById(charityId);
    }

    public List<Charity> findCharities(String name){
        Charity exampleCharity = new Charity();
        exampleCharity.setName(name);
        Example<Charity> example = Example.of(exampleCharity);
        return chartiyDao.findAll(example);
    }

    public List<Charity> finalAllCharities(){
        return chartiyDao.findAll();
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
