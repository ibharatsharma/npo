package com.npo.campaign;

import com.npo.domain.Campaign;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/charities/{charityId}/campaigns")
public class CampaignController {

    private final CampaignService campaignService;

    @GetMapping
    public String getAllCampaigns(@PathVariable Long charityId, Model model) {
        List<Campaign> campaigns = campaignService.findByCharityId(charityId);
        model.addAttribute("charityId", charityId);
        model.addAttribute("campaignCount", campaigns.size());
        model.addAttribute("campaigns", campaigns);
        return "campaign/listCampaigns";
    }

    @GetMapping("/new")
    public String showCampaignForm(@PathVariable Long charityId, final Model model) {
        var campaign = new CampaignDto();
        model.addAttribute("dto", campaign);
        model.addAttribute("charityId", charityId);
        return "campaign/newCampaign";
    }

    @PostMapping
    public String processCampaignForm(@PathVariable Long charityId, @Validated CampaignDto campaignDto, final Model model) {
        // persist into database.
        log.info("campaignDto: {}", campaignDto);
        Campaign savedCampaign = campaignService.createCampaign(charityId, campaignDto);

        if (savedCampaign.getId() != null) {
            // event was created successfully
            model.addAttribute("charityId", charityId);
            model.addAttribute("dto", campaignDto);
            model.addAttribute("message", "Campaign Created!");
            return "redirect:/charities/" + charityId + "/campaigns";
        } else {
            model.addAttribute("dto", campaignDto);
            model.addAttribute("charityId", charityId);
            return "campaign/newCampaign";
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCampaign(@PathVariable String id){
        campaignService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
