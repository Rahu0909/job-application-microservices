package com.project.jobappservice.job.utility;

import com.project.jobappservice.job.dto.JobDTO;
import com.project.jobappservice.job.external.Company;
import com.project.jobappservice.job.external.Review;
import com.project.jobappservice.job.model.Job;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JobMapper {
    public static JobDTO mapToJobWithCompanyDTO(Job job, Company company, List<Review> review) {
        JobDTO jobDTO = new JobDTO();
        jobDTO.setId(job.getId());
        jobDTO.setTitle(job.getTitle());
        jobDTO.setDescription(job.getDescription());
        jobDTO.setLocation(job.getLocation());
        jobDTO.setMaxSalary(job.getMaxSalary());
        jobDTO.setMinSalary(job.getMinSalary());
        jobDTO.setCompany(company);
        jobDTO.setReview(review);
        return jobDTO;
    }
}
