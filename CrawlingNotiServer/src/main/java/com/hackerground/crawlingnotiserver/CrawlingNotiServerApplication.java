package com.hackerground.crawlingnotiserver;

import com.hackerground.crawlingnotiserver.entity.dash.DashSpace;
import com.hackerground.crawlingnotiserver.service.dash.DashAnnouncementService;
import com.hackerground.crawlingnotiserver.service.dash.DashSpaceService;
import com.hackerground.crawlingnotiserver.service.job.JobCompanyService;
import com.hackerground.crawlingnotiserver.service.job.JobPublicCompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
@RequiredArgsConstructor
public class CrawlingNotiServerApplication {
    private final DashAnnouncementService dashAnnouncementService;
    private final DashSpaceService dashSpaceService;
    private final JobCompanyService jobCompanyService;
    private final JobPublicCompanyService jobPublicCompanyService;

    public static void main(String[] args) {
        SpringApplication.run(CrawlingNotiServerApplication.class, args);
        //서버 실행 시 무조건 한번 전체 사이트에 대한 크롤링 진행
    }

    @Scheduled(fixedDelay = 30000) // Run every 30sec
    public void executeTask() {
//        dashAnnouncementService.crawlingTask();
//        dashSpaceService.crawlingTask();
//        jobCompanyService.crawlingTask();
        jobPublicCompanyService.crawlingTask();
    }
}

