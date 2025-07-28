package com.npo.campaign;

import com.npo.domain.Campaign;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/charities/{charityId}/campaigns")
public class CampaignController {

    private final CampaignService campaignService;

    @GetMapping
    public String getAllCampaigns(@PathVariable Long charityId,
                                  @RequestParam(name = "internal", defaultValue = "false") Boolean internal,
                                  Model model) {
        log.info("Internal={}", internal);
        List<Campaign> campaigns = campaignService.findByCharityId(charityId);
        model.addAttribute("charityId", charityId);
        model.addAttribute("campaignCount", campaigns.size());
        model.addAttribute("campaigns", campaigns);
        if(internal){
            return "campaign/campaignTable";
        }
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

    @PutMapping("/{campaignId}")
    public String editCampaignForm(@PathVariable Long charityId,
                                   @PathVariable("campaignId") String campaignId,
                                   final Model model) {
        Optional<Campaign> campaignOptional = campaignService.findById(campaignId);

        return campaignOptional.map(campaign -> {
            CampaignDto dto = new CampaignDto();
            dto.setCampaignId(campaign.getId());
            dto.setCampaignTitle(campaign.getTitle());
            dto.setDescription(campaign.getDescription());
            model.addAttribute("dto", dto);
            model.addAttribute("charityId", charityId);
            model.addAttribute("campaignId", campaignId);
            return "campaign/newCampaign";
        }).orElseThrow(() -> new RuntimeException("Error editing Campaign"));

    }

    @GetMapping("{id}")
    public String findById(@PathVariable Long charityId, @PathVariable("id") String id, Model model){
        Optional<Campaign> optionalCampaign = campaignService.findById(id);
        optionalCampaign.map(campaign -> {
            model.addAttribute("charityId", charityId);
            model.addAttribute("campaign", campaign);
            return campaign;
        });
        return "campaign/campaignDetail";
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCampaign(@PathVariable String id){
        campaignService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
