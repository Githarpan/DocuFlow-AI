
package com.docuflow.backend.repository;

import com.docuflow.backend.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CompanyRepository
        extends JpaRepository<Company, UUID> {

    // Find companies by GSTIN
    List<Company> findByGstin(String gstin);

    // Search companies by name (case-insensitive)
    List<Company> findByCompanyNameContainingIgnoreCase(
            String companyName);

    // Find all active companies
    List<Company> findByActiveTrue();
}
