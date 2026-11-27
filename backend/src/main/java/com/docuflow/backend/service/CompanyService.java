
package com.docuflow.backend.service;

import com.docuflow.backend.dto.CompanyRequest;
import com.docuflow.backend.dto.CompanyResponse;
import com.docuflow.backend.entity.Company;
import com.docuflow.backend.repository.CompanyRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    // Create company
    public CompanyResponse createCompany(CompanyRequest request) {

        Company company = new Company();

        company.setCompanyName(request.companyName());
        company.setGstin(request.gstin());
        company.setEmail(request.email());
        company.setPhone(request.phone());
        company.setAddress(request.address());
        company.setStateCode(request.stateCode());

        Company savedCompany = companyRepository.save(company);

        return mapToResponse(savedCompany);
    }

    // Get all companies
    public List<CompanyResponse> getAllCompanies() {

        return companyRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // Get company by ID
    public CompanyResponse getCompanyById(UUID id) {

        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Company not found: " + id
                ));

        return mapToResponse(company);
    }

    // Search by GSTIN
    public List<CompanyResponse> getCompaniesByGstin(String gstin) {

        return companyRepository.findByGstin(gstin)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // Search by company name
    public List<CompanyResponse> searchCompaniesByName(String name) {

        return companyRepository
                .findByCompanyNameContainingIgnoreCase(name)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // Get active companies
    public List<CompanyResponse> getActiveCompanies() {

        return companyRepository.findByActiveTrue()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // Convert Entity to Response DTO
    private CompanyResponse mapToResponse(Company company) {

        return new CompanyResponse(
                company.getId(),
                company.getCompanyName(),
                company.getGstin(),
                company.getEmail(),
                company.getPhone(),
                company.getAddress(),
                company.getStateCode(),
                company.isActive(),
                company.getCreatedAt(),
                company.getUpdatedAt()
        );
    }
}
