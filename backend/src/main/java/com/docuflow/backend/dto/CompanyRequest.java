
package com.docuflow.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CompanyRequest(

        @NotBlank(message = "Company name is required")
        @Size(max = 150, message = "Company name cannot exceed 150 characters")
        String companyName,

        @Size(max = 15, message = "GSTIN cannot exceed 15 characters")
        String gstin,

        @Email(message = "Please provide a valid email address")
        @Size(max = 150)
        String email,

        @Size(max = 20)
        String phone,

        String address,

        @Size(max = 2)
        String stateCode

) {}
