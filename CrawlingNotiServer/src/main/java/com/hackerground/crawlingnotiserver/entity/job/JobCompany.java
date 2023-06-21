package com.hackerground.crawlingnotiserver.entity.job;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jsoup.nodes.Element;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity(name = "JobCompany")
@NoArgsConstructor
public class JobCompany {
    @Id
    private String id;
    private String companyName;
    private String title;
    private String location;
    private String career;
    private String education;
    private String payType;
    private String dday;
    private String link;

    public JobCompany(Element element) {
        setCompanyName(element);
        setTitle(element);
        setLocation(element);
        setCareer(element);
        setEducation(element);
        setPayType(element);
        setDday(element);
        setLink(element);
    }

    public void setCompanyName(Element element) {
        String companyName = element.select("td b").first().text();
        this.companyName = companyName;
    }


    public void setTitle(Element element) {
        this.title = title;
    }

    public void setLocation(Element element) {
        this.location = location;
    }

    public void setCareer(Element element) {
        this.career = career;
    }

    public void setEducation(Element element) {
        this.education = education;
    }

    public void setPayType(Element element) {
        this.payType = payType;
    }

    public void setDday(Element element) {
        this.dday = dday;
    }

    public void setLink(Element element) {
        Element button = element.select("button").first();
        String projectId = button.id();
        this.link = "https://job.daegu.go.kr/daegujob/searchJobView?" + projectId;
    }
}
