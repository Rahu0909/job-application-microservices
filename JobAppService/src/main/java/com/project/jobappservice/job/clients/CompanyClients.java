package com.project.jobappservice.job.clients;

import com.project.jobappservice.job.external.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COMPANYAPPSERVICE",
        url = "${company-service.url}")
public interface CompanyClients {
    @GetMapping("/companies/{id}")
    Company getCompany(@PathVariable("id") Long id);
}
