package com.hackerground.crawlingnotiserver.repository.job;

import com.hackerground.crawlingnotiserver.entity.job.JobPublicCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPublicCompanyRepository extends JpaRepository<JobPublicCompany, String> {
}
