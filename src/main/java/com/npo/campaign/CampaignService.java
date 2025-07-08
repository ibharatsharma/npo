package com.npo.campaign;

import com.npo.charity.CharityDto;
import com.npo.charity.CharityService;
import com.npo.domain.Campaign;
import com.npo.domain.Charity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CampaignService {

    private final CampaignDao campaignDao;
    private final CharityService charityService;

    public List<Campaign> findByCharityId(Long charityId){
        return campaignDao.findByCharityId(charityId);
    }

    public Campaign createCampaign(Long charityId, CampaignDto campaignDto){

        Optional<Charity> charityOptional = charityService.findCharity(charityId);
        return charityOptional.map(charity -> {
                    Campaign campaign = dtoToCampaign(campaignDto);
                    campaign.setCharity(charity);
                    return campaignDao.save(campaign);
        }).orElseThrow(() -> new RuntimeException("Campaign could not be persisted"));
    }

    private Campaign dtoToCampaign(CampaignDto dto){
        return Campaign.builder()
                .title(dto.getCampaignTitle())
                .description(dto.getDescription())
                .build();
    }
}
