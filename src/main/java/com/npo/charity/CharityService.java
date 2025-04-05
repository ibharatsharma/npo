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

    private final ChartiyDao chartiyDao;

    public void saveCharity(final Charity charity){
        chartiyDao.save(charity);
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


}
