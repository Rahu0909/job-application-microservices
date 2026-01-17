package com.project.jobappservice.job.service;

import com.project.jobappservice.job.dto.JobDTO;
import com.project.jobappservice.job.model.Job;

import java.util.List;

public interface JobService {
    List<JobDTO> findAll();

    void createJob(Job job);

    JobDTO getJobById(Long id);

    boolean deleteJobById(Long id);

    boolean updateJob(Long id, Job updatedJob);
}

