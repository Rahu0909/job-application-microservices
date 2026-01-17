package com.project.jobappservice.job.serviceImpl;

import com.project.jobappservice.job.clients.CompanyClients;
import com.project.jobappservice.job.clients.ReviewClients;
import com.project.jobappservice.job.dto.JobDTO;
import com.project.jobappservice.job.external.Company;
import com.project.jobappservice.job.external.Review;
import com.project.jobappservice.job.model.Job;
import com.project.jobappservice.job.repository.JobRepository;
import com.project.jobappservice.job.service.JobService;
import com.project.jobappservice.job.utility.JobMapper;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;
    private final CompanyClients companyClients;
    private final ReviewClients reviewClients;
    private final RestTemplate restTemplate;
    private final JobMapper jobMapper;

    int attempt=0;

    @Override
//    @CircuitBreaker(name = "companyBreaker",
//            fallbackMethod = "companyBreakerFallback")
//    @Retry(name = "companyBreaker",
//           fallbackMethod = "companyBreakerFallback")
    @RateLimiter(name = "companyBreaker",
            fallbackMethod = "companyBreakerFallback")
    public List<JobDTO> findAll() {
        System.out.println("Attempt " + ++attempt);
        List<Job> jobs = jobRepository.findAll();
        List<JobDTO> jobDTOS = new ArrayList<>();

        return jobs.stream().map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public List<JobDTO> companyBreakerFallback(Throwable ex) {
        List<JobDTO> fallbackJobs = new ArrayList<>();

        JobDTO dummyJob = new JobDTO();
        dummyJob.setTitle("Service temporarily unavailable");
        dummyJob.setDescription("Company service is down");

        fallbackJobs.add(dummyJob);
        return fallbackJobs;
    }

    private JobDTO convertToDto(Job job) {
//        Company company = restTemplate.getForObject(
//                "http://COMPANYAPPSERVICE:8082/companies/" + job.getCompanyId(),
//                Company.class);
        Company company = companyClients.getCompany(job.getCompanyId());
//                org.springframework.http.ResponseEntity < List < Review >> reviewResponse =
//                        restTemplate.exchange("http://REVIEWAPPSERVICE:8083/reviews?companyId=" + job.getCompanyId(),
//                                HttpMethod.GET,
//                                null,
//                                new ParameterizedTypeReference<List<Review>>() {
//                                });
        List<Review> reviews = reviewClients.getReviews(job.getCompanyId());

        JobDTO jobDTO = jobMapper.mapToJobWithCompanyDTO(job, company, reviews);
//        JobDTO jobDTO = jobMapper.mapToJobWithCompanyDTO(
//                job, company);
        jobDTO.setCompany(company);

        return jobDTO;
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public JobDTO getJobById(Long id) {
        Job job = jobRepository.findById(id).orElse(null);
        return convertToDto(job);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setLocation(updatedJob.getLocation());
            job.setCompanyId(updatedJob.getCompanyId());
            jobRepository.save(job);
            return true;
        }
        return false;
    }
}