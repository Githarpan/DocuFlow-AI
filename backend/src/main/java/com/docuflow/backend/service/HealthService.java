package com.docuflow.backend.service;

import org.springframework.stereotype.Service;

import com.docuflow.backend.dto.HealthResponse;

@Service
public class HealthService {

    public HealthResponse getHealthStatus() {
        return new HealthResponse(
                "UP",
                "DocuFlow AI",
                "Application is running successfully"
        );
    }
}