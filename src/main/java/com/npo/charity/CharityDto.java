package com.npo.charity;

import lombok.Data;

@Data
public class CharityDto {
    private String name;                // Name of the charity
    private String registrationNumber;  // Unique identifier for legal registration
    private String purpose;             // The charitable purpose or mission
    private String address;             // Physical address of the charity
    private String contactInfo;         // Phone number or email for communication
    private double funds;               // Total funds available
    private boolean isActive;           // Status of the charity (active/inactive)
}
