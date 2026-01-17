package com.project.jobappservice.job.clients;

import com.project.jobappservice.job.external.Company;
import com.project.jobappservice.job.external.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "REVIEWAPPSERVICE",
        url = "${review-service.url}")
public interface ReviewClients {
    @GetMapping("/reviews")
    List<Review> getReviews(@RequestParam("companyId") Long companyId);
}
