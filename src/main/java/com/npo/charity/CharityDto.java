package com.npo.charity;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CharityDto {
    @NotBlank(message = "Charity name is required.")
    private String name;                // Name of the charity
    @NotBlank(message = "Charity registration number is required.")
    private String registrationNumber;  // Unique identifier for legal registration
    @NotBlank(message = "Please provide purpose of your charity")
    private String purpose;             // The charitable purpose or mission
    @NotBlank(message = "Please provide address")
    private String address;             // Physical address of the charity
    @NotBlank(message = "Please provide contact/phone number")
    private String contactInfo;         // Phone number or email for communication
    private boolean isActive;           // Status of the charity (active/inactive)
}
