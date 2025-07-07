package com.npo.campaign;

import com.npo.domain.Campaign;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CampaignService {

    public List<Campaign> findByCharityId(Long charityId){
        return Collections.emptyList();
    }

    public Campaign createCampaign(Long charityId, CampaignDto campaignDto){
        return new Campaign();
    }
}
