package com.docuflow.backend.dto;

public record HealthResponse(
        String status,
        String application,
        String message
) {
}