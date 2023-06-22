package com.hackerground.crawlingnotiserver.service.job;

import com.hackerground.crawlingnotiserver.constant.URLs;
import com.hackerground.crawlingnotiserver.entity.job.JobCompany;
import com.hackerground.crawlingnotiserver.repository.job.JobCompanyRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobCompanyService {
    private JobCompanyRepository repository;
    private List<JobCompany> jobCompanies;
    private WebDriver driver;
    private int maxPageIndex = 0;


    public JobCompanyService(JobCompanyRepository repository) {
        this.repository = repository;
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "/Users/jeongchan-yeong/Desktop/chromedriver");
        this.jobCompanies = new ArrayList<>();
    }

    public boolean crawlingTask() {
        this.driver = new ChromeDriver();

        int pageIndex = 1;  //페이지 번호 = 첫 페이지
        boolean notification = false;   //알림 송신 여부

        //웹 연결
        driver.get(URLs.JobPrivateCompany);

        //====================최신 공고 체크====================/
        String pageSource = driver.getPageSource(); //최신순으로 정렬된 페이지
        Document doc = Jsoup.parse(pageSource);


        if (notiCheck(doc)) notification = true;

        //각 페이지를 이동하면서 마감 공고 이전까지 크롤링
        while (true) {
            //============================크롤링=============================//
            //크롤링에 사용할 페이지 정보 받기
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            pageSource = driver.getPageSource();
            doc = Jsoup.parse(pageSource);

            //버튼 저장
            List<WebElement> buttons = driver.findElements(By.cssSelector(".page_num"));
            maxPageIndex = buttons.size();

            //크롤링 결과 = 마감여부 = true => break;
            saveCompany(doc);

            //=========================다음 페이지 이동=========================//
            WebElement nextPageButton;

            //일반 경우 다음 페이지로 이동
            pageIndex++;

            if(pageIndex > maxPageIndex)
                break;
            else{
                nextPageButton = buttons.get(pageIndex-1);
                nextPageButton.click();

            }
        }
        //크롤링 종료 후
        //DB의 모든 데이터 삭제
        repository.deleteAll();
        //DB에 새로운 데이터 저장
        Iterable<JobCompany> jobCompanyIterable = jobCompanies;
        repository.saveAll(jobCompanyIterable);

        //브라우저 종료
        driver.quit();

        return notification;
    }

    public boolean notiCheck(Document document) {
        //크롤링으로 첫 번째 공고 데이터 가져오기
        Element element = document.select("#searchJobList tr").first();
        //첫 번째 공고의 아이디 가져오기
        Element button = element.select("button").first();
        String projectId = button.id();

        //최신 공고에서 첫 번째 데이터를 DB에서 조회
        Optional<JobCompany> jobCompany = repository.findById(projectId);
        //값이 없다면 새로운 공고가 있음
        if(jobCompany.isEmpty()){
            return true;
        }
        return false;
    }

    public boolean saveCompany(Document document) {
        //여기서는 크롤링만 진행하고 최신 공고 비교와 알림 기능은 도형이가 만든 서비스에 추가
        boolean isClosed = false;

        //전체 크롤링 후 저장
        Elements elements = document.select("#searchJobList tr");

        //크롤링 된 데이터를 DashAnnouncement foreach를 사용해 객체로 변환
        for (Element element : elements) {
            JobCompany jobCompany = new JobCompany(element);
            //List에 객체 추가
            jobCompanies.add(jobCompany);
        }

        return isClosed;
    }
}
