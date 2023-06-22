package com.example.crawling;

import com.example.crawling.service.dash.DashAnnouncementService;
import com.example.crawling.service.dash.DashSpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
@RequiredArgsConstructor
public class CrawlingApplication {
	private final DashAnnouncementService dashAnnouncementService;
	private final DashSpaceService dashSpaceService;

	public static void main(String[] args) {
		SpringApplication.run(CrawlingApplication.class, args);
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("webdriver.chrome.driver", "/Users/jeongchan-yeong/Desktop/chromedriver");
		//서버 실행 시 무조건 한번 전체 사이트에 대한 크롤링 진행
	}

	@Scheduled(fixedDelay = 30000) // Run every 30sec
	public void executeTask() {
//		dashAnnouncementService.crawlingTask();
		dashSpaceService.crawlingTask();
	}
}

