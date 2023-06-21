package com.hackerground.crawlingnotiserver.service.dash;

import com.hackerground.crawlingnotiserver.constant.URLs;
import com.hackerground.crawlingnotiserver.entity.dash.DashAnnouncement;
import com.hackerground.crawlingnotiserver.repository.dash.DashAnnouncementRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DashAnnouncementService {
    private DashAnnouncementRepository repository;
    private WebDriver driver;
    private List<DashAnnouncement> dashAnnouncements;

    @Autowired
    public DashAnnouncementService(DashAnnouncementRepository repository) {
        this.repository = repository;
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "/Users/jeongchan-yeong/Desktop/chromedriver");
        dashAnnouncements = new ArrayList<>();
    }

    public boolean crawlingTask() {
        this.driver = new ChromeDriver();

        int pageIndex = 1;  //페이지 번호 = 첫 페이지
        boolean notification = false;   //알림 송신 여부

        //웹 연결
        driver.get(URLs.dashAnnouncement);

        //====================최신 공고 체크====================/
        String pageSource = driver.getPageSource(); //최신순으로 정렬된 페이지
        Document doc = Jsoup.parse(pageSource);
        if (notiCheck(doc)) notification = true;

        //정렬 기준을 마감순으로 변경
        WebElement sortingElement = driver.findElement(By.name("searchCondition9"));
        sortingElement.sendKeys("마감순");

        //변경된 기준으로 정렬
        WebElement viewButton = driver.findElement(By.cssSelector(".top_tit .button"));
        viewButton.click();

        //각 페이지를 이동하면서 마감 공고 이전까지 크롤링
        while (true) {
            //============================크롤링=============================//
            //크롤링에 사용할 페이지 정보 받기
            pageSource = driver.getPageSource();
            doc = Jsoup.parse(pageSource);

            //크롤링 결과 = 마감여부 = true => break;
            if (saveAnnouncement(doc)) break;

            //=========================다음 페이지 이동=========================//
            WebElement nextPageButton;
            //10 페이지 단위로 다음 페이지 버튼으로 이동
            if (pageIndex % 10 == 0) {
                nextPageButton = driver.findElement(By.className("page_next"));
                pageIndex++;
            }
            //일반 경우 다음 페이지로 이동
            else {
                pageIndex++;
                nextPageButton = driver.findElement(By.linkText(String.valueOf(pageIndex)));
            }
            nextPageButton.click();
        }
        //크롤링 종료 후
        //DB의 모든 데이터 삭제
        repository.deleteAll();
        //DB에 새로운 데이터 저장
        Iterable<DashAnnouncement> dashAnnouncementsIterable = dashAnnouncements;
        repository.saveAll(dashAnnouncementsIterable);

        //브라우저 종료
        driver.quit();

        return notification;
    }

    public boolean notiCheck(Document document) {
        //크롤링으로 첫 번째 공고 데이터 가져오기
        Element element = document.select(".dtl_lst li").first();
        //첫 번째 공고의 아이디 가져오기
        Element button = element.select("button").first();
        String buttonId = button.id();
        int projectId = Integer.parseInt(buttonId.substring(18, 25)); //예시: favorite_PROJECT_00003365


        //최신 공고에서 첫 번째 데이터를 DB에서 조회
        Optional<DashAnnouncement> dashAnnouncement = repository.findById(projectId);
        //값이 없다면 새로운 공고가 있음
        if(dashAnnouncement.isEmpty()){
            return true;
        }
        return false;
    }

    public boolean saveAnnouncement(Document document) {
        //여기서는 크롤링만 진행하고 최신 공고 비교와 알림 기능은 도형이가 만든 서비스에 추가
        boolean isClosed = false;

        //전체 크롤링 후 저장
        Elements elements = document.select(".dtl_lst li");

        //크롤링 된 데이터를 DashAnnouncement foreach를 사용해 객체로 변환
        for (Element element : elements) {
            DashAnnouncement announcement = new DashAnnouncement(element);

            //만료된 공고라면 foreach를 중단 후 isClosed를 true로 저장
            if(announcement.getDday().equals("마감")){
                isClosed = true;
                break;
            }
            //List에 객체 추가
            dashAnnouncements.add(announcement);
        }

        return isClosed;
    }
}
