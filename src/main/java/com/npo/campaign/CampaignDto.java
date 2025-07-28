package com.npo.campaign;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CampaignDto {

    private String campaignId;
    @NotBlank(message = "Please provide a Title for your Campaign.")
    private String campaignTitle;
    @NotBlank(message = "Describe the purpose of your campaign.")
    private String description;
}
