package com.npo.campaign;

import com.npo.charity.CharityDto;
import com.npo.charity.CharityService;
import com.npo.domain.Campaign;
import com.npo.domain.Charity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class CampaignService {

    private final CampaignDao campaignDao;
    private final CharityService charityService;

    public List<Campaign> findByCharityId(Long charityId){
        return campaignDao.findByCharityId(charityId);
    }

    public Campaign createCampaign(Long charityId, CampaignDto campaignDto){
        log.info("createCampaign: charityId={}, campaignTitle={}", charityId, campaignDto.getCampaignTitle());
        Optional<Charity> charityOptional = charityService.findCharity(charityId);
        log.info("charityOptional isPresent={}", charityOptional.isPresent());
        return charityOptional.map(charity -> {
                    Campaign campaign = dtoToCampaign(campaignDto);
                    campaign.setCharity(charity);
                    return campaignDao.save(campaign);
        }).orElseThrow(() ->
            new RuntimeException("Campaign could not be persisted")
        );
    }

    public Optional<Campaign> findById(final String id){
        return campaignDao.findById(id);
    }

    public void deleteById(final String id){
        if(id == null){
            throw new IllegalArgumentException("Campaign id was null");
        }
        campaignDao.deleteById(id);
    }

    private Campaign dtoToCampaign(CampaignDto dto){
        return Campaign.builder()
                .id(UUID.randomUUID().toString())
                .title(dto.getCampaignTitle())
                .description(dto.getDescription())
                .build();
    }

}
