package com.npo.campaign;

import com.npo.domain.Campaign;
import com.npo.domain.Charity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignDao extends JpaRepository<Campaign, String> {

    List<Campaign> findByCharityId(Long charityId);
}
