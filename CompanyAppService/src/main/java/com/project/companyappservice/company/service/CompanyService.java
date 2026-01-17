package com.project.companyappservice.company.service;

import com.project.companyappservice.company.dto.ReviewMessage;
import com.project.companyappservice.company.model.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();

    boolean updateCompany(Company company, Long id);

    void createCompany(Company company);

    boolean deleteCompanyById(Long id);

    Company getCompanyById(Long id);

    public void updateCompanyRating(ReviewMessage reviewMessage);
}
