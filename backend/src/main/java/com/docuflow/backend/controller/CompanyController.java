
package com.docuflow.backend.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.docuflow.backend.dto.CompanyRequest;
import com.docuflow.backend.dto.CompanyResponse;
import com.docuflow.backend.service.CompanyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    // Register company
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompanyResponse createCompany(
            @Valid @RequestBody CompanyRequest request) {

        return companyService.createCompany(request);
    }

    // Get all companies
    @GetMapping
    public List<CompanyResponse> getAllCompanies() {

        return companyService.getAllCompanies();
    }

    // Get company by ID
    @GetMapping("/{id}")
    public CompanyResponse getCompanyById(@PathVariable UUID id) {

        return companyService.getCompanyById(id);
    }

    // Search by GSTIN
    @GetMapping("/search")
    public List<CompanyResponse> searchByGstin(
            @RequestParam String gstin) {

        return companyService.getCompaniesByGstin(gstin);
    }

    // Search by company name
    @GetMapping("/search/name")
    public List<CompanyResponse> searchByName(
            @RequestParam String name) {

        return companyService.searchCompaniesByName(name);
    }

    // Get active companies
    @GetMapping("/active")
    public List<CompanyResponse> getActiveCompanies() {

        return companyService.getActiveCompanies();
    }
}
