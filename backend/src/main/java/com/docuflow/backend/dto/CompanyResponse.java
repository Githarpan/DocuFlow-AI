
package com.docuflow.backend.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record CompanyResponse(
        UUID id,
        String companyName,
        String gstin,
        String email,
        String phone,
        String address,
        String stateCode,
        boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
