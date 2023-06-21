package com.hackerground.crawlingnotiserver.repository.job;

import com.hackerground.crawlingnotiserver.entity.job.JobCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobCompanyRepository extends JpaRepository<JobCompany, String> {
}
